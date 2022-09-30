package com.ec.demo.cache;

import com.ec.demo.enums.CacheRefreshType;

import java.math.BigDecimal;
import java.util.Map;

public interface ICache<T> {
    /**
     * 缓存数据的KEY（重要）
     * 获取缓存数据的时候需要使用
     *
     * @return Class
     */
    Class<?> getCacheObjectType();

    /**
     * 区分会计日的的缓存数据
     *
     * @param acDate 会计日
     * @return Map
     */
    Map<String, T> cacheObject(BigDecimal acDate);

    /**
     * 缓存的数据
     * T 为具体要缓存的对象类型
     *
     * @return Map<String, T>
     */
    Map<String, T> cacheObject();

    /**
     * 检查缓存策略
     *
     * @param refreshType 刷新类型
     * @return Boolean
     */
    Boolean checkCachRefreshPolicy(CacheRefreshType refreshType);
}
