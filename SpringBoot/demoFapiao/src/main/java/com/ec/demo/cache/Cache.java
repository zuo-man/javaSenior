package com.ec.demo.cache;

import com.ec.demo.enums.CacheRefreshType;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.*;

public class Cache implements ApplicationContextAware , SmartLifecycle {
    private final Logger logger = LoggerFactory.getLogger(Cache.class);

    private Map<String, ICache> cacheIntializer;

    private final Map<Class<?>, Map<String, ?>> cacheObjectMap = new ConcurrentHashMap<>();

    private final Map<Class<?>, Class<?>> cacheObjectType = new ConcurrentHashMap<>();

    private Boolean autoStart = false;

    private ApplicationContext context;

    public Map<String, ?> get(final Class clazz) {

        final Map<String, ?> cacheObject = this.cacheObjectMap.get(clazz);
        if (CollectionUtils.isEmpty(cacheObject)) {
            this.logger.debug("未找到此类型的缓存 {}", clazz);
            return Collections.EMPTY_MAP;
        }
//        Assert.isTrue(!this.cacheObjectType.get(clazz).isAssignableFrom(Map.class), "获取的类型与缓存数据类型不匹配");
        return this.cacheObjectMap.get(clazz);

    }

    public <T> Map<String, T> getWithTypeCase(final Class<T> clazz) {

        final Map<String, ?> cacheObject = this.cacheObjectMap.get(clazz);
        if (CollectionUtils.isEmpty(cacheObject)) {
            this.logger.debug("未找到此类型的缓存 {}", clazz);
            return Collections.EMPTY_MAP;
        }
        Assert.isTrue(clazz.isAssignableFrom(this.cacheObjectType.get(clazz)), "获取的类型与缓存数据类型不匹配");
        return (Map<String, T>) this.cacheObjectMap.get(clazz);

    }

    public Boolean getAutoStart() {
        return this.autoStart;
    }

    public <T> Map<String, List<T>> getList(final Class<T> clazz) {

        final Map<String, ?> cacheObject = this.cacheObjectMap.get(clazz);
        if (CollectionUtils.isEmpty(cacheObject)) {
            return Collections.EMPTY_MAP;
        }
        Assert.isTrue(!this.cacheObjectType.get(clazz).isAssignableFrom(List.class), "获取的类型与缓存数据类型不匹配");
        return (Map<String, List<T>>) this.cacheObjectMap.get(clazz);

    }

    @Override
    public int getPhase() {
        return 0;
    }

    public <T> Map<String, Set<T>> getSet(final Class<T> clazz) {

        final Map<String, ?> cacheObject = this.cacheObjectMap.get(clazz);
        if (CollectionUtils.isEmpty(cacheObject)) {
            return Collections.EMPTY_MAP;
        }
        Assert.isTrue(!this.cacheObjectType.get(clazz).isAssignableFrom(Set.class), "获取的类型与缓存数据类型不匹配");
        return (Map<String, Set<T>>) this.cacheObjectMap.get(clazz);

    }

    /**
     * @Method: initialize
     * @Description: 缓存初次加载数据
     * @return: void
     */
    public void initialize() {

        this.logger.info("cache initialize started");
        final Long startTime = System.currentTimeMillis();

        this.cacheIntializer = this.context.getBeansOfType(ICache.class);

        if (CollectionUtils.isEmpty(this.cacheIntializer)) {
            return;
        }

        final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("cache-initializer-%d")
                .setUncaughtExceptionHandler((t, e) -> this.logger.error(e.getMessage(), e)
                ).build();
        // 使用多线程初始化缓存，提高系统启动速度
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), threadFactory);

        for (final ICache<?> cache : this.cacheIntializer.values()) {

            executor.execute(() -> {
                MDC.put("requestId", "cacheRefresh");
                logger.debug("thread pool executor execute ...");
                try {
                    final Map<String, ?> cacheObject = cache.cacheObject();
                    if (CollectionUtils.isEmpty(cacheObject)) {
                        return;
                    }
                    final Object firstObject = cacheObject.values().iterator().next();
                    this.cacheObjectType.put(cache.getCacheObjectType(), firstObject.getClass());
                    this.cacheObjectMap.put(cache.getCacheObjectType(), cacheObject);
                    logger.debug("{} cache init finished", firstObject.getClass().getName());
                } catch (final Exception e) {
                    this.logger.error("cache object failed:{}", e.getMessage(), e);
                }

                MDC.remove("requestId");
            });
        }

        // 发送线程池停止信号到线程池
        executor.shutdown();

        // 判断线程池是否停止，没有停止就1秒检查一次
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(10);
            } catch (final InterruptedException e) {
                this.logger.error("缓存更新失败", e);
                Thread.currentThread().interrupt();
            }
        }
        this.logger.info("cache initialize finished,time(ms):{}", System.currentTimeMillis() - startTime);
    }

    @Override
    public boolean isAutoStartup() {
        return this.autoStart;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    /**
     * @Method: refreshByDay
     * @Description: 按日刷新缓存
     * @return: void
     */
    public void refreshByDay() {
        MDC.put("requestId", "cacheRefresh_refreshByDay");
        logger.debug("refreshByDay:" + new Date().toString());
        if (CollectionUtils.isEmpty(this.cacheIntializer)) {
            return;
        }
        for (final ICache<?> cache : this.cacheIntializer.values()) {
            if (cache.checkCachRefreshPolicy(CacheRefreshType.DAY)) {
                try {
                    final Map<String, ?> cacheObject = cache.cacheObject();
                    final Object firstObject = cacheObject.values().iterator().next();
                    this.cacheObjectType.put(cache.getCacheObjectType(), firstObject.getClass());
                    this.cacheObjectMap.put(cache.getCacheObjectType(), cacheObject);
                } catch (final Exception e) {
                    this.logger.error("cache object failed:{}", e.getMessage(), e);
                }

            }
        }

        MDC.remove("requestId");

    }
    /**
     * 立刻刷新某种类型的缓存
     *
     * @param clazz 需要刷新的缓存类型
     */
    public void refreshNow(Class<? extends ICache> clazz) {
        MDC.put("requestId", "cacheRefresh_refreshNow");
        final String name = lowerFirst(clazz.getSimpleName());
        final ICache cache = this.cacheIntializer.get(name);
        if (null == cache) {
            return;
        }
        try {
            final Map<String, ?> cacheObject = cache.cacheObject();
            final Object firstObject = cacheObject.values().iterator().next();
            this.cacheObjectType.put(cache.getCacheObjectType(), firstObject.getClass());
            this.cacheObjectMap.put(cache.getCacheObjectType(), cacheObject);
            logger.debug("cache [{}] refresh success", cache.getClass().getName());
        } catch (final Exception e) {
            this.logger.error("cache object failed:{}", e.getMessage(), e);
        }

        MDC.remove("requestId");
    }
    /**
     * @Method: refreshByMin
     * @Description: 按分钟刷新缓存
     * @return: void
     */
    public void refreshByMin() {
        MDC.put("requestId", "cacheRefresh_refreshByMin");
        logger.debug("refreshByMin:" + new Date().toString());
        if (CollectionUtils.isEmpty(this.cacheIntializer)) {
            return;
        }

        for (final ICache<?> cache : this.cacheIntializer.values()) {
            if (cache.checkCachRefreshPolicy(CacheRefreshType.MINUTE)) {
                try {
                    final Map<String, ?> cacheObject = cache.cacheObject();
                    final Object firstObject = cacheObject.values().iterator().next();
                    this.cacheObjectType.put(cache.getCacheObjectType(), firstObject.getClass());
                    this.cacheObjectMap.put(cache.getCacheObjectType(), cacheObject);
                    logger.debug("{} refreshByMin finished", firstObject.getClass().getName());
                } catch (final Exception e) {
                    this.logger.error("cache object failed:{}", e.getMessage(), e);
                }
            }
        }
        MDC.remove("requestId");
    }

    public void refreshByHour() {
        MDC.put("requestId", "cacheRefresh_refreshByHour");
        logger.debug("refreshByHour:" + new Date().toString());
        if (CollectionUtils.isEmpty(this.cacheIntializer)) {
            return;
        }
        for (final ICache<?> cache : this.cacheIntializer.values()) {
            if (cache.checkCachRefreshPolicy(CacheRefreshType.HOUR)) {
                try {
                    final Map<String, ?> cacheObject = cache.cacheObject();
                    this.cacheObjectMap.put(cache.getCacheObjectType(), cacheObject);
                    if (CollectionUtils.isEmpty(cacheObject)) {
                        continue;
                    }
                    final Object firstObject = cacheObject.values().iterator().next();
                    this.cacheObjectType.put(cache.getCacheObjectType(), firstObject.getClass());
                } catch (final Exception e) {
                    this.logger.error("cache object failed:{}", e.getMessage(), e);
                }

            }
        }
        MDC.remove("requestId");
    }

    private String lowerFirst(String str) {
        char[] cs = str.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void setAutoStart(final Boolean autoStart){
        this.autoStart = autoStart;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}
