package com.ec.demo.cache.ErrorCache;

import com.ec.demo.cache.Cache;
import com.ec.demo.cache.ErrorCache.ErrorEntry;
import com.ec.demo.cache.ManageSpringBeans;
import com.ec.demo.cache.impl.ErrCodeCache;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ErrCodeUtil {

    /**
     * 根据错误信息获取错误信息
     * @param errCode
     * @return
     */
    public static String getErrInf(String errCode){
        Cache cache = ManageSpringBeans.getBean(Cache.class);
        Map<String, ErrorEntry> cacheMap = cache.getWithTypeCase(ErrorEntry.class);
        if (cacheMap==null || cacheMap.isEmpty()){
            //缓存失效，立即刷新
            cache.refreshNow(ErrCodeCache.class);
        }
        if (cacheMap != null && cacheMap.containsKey(errCode)){
            return cacheMap.get(errCode).getErrInf();
        }
        return "错误";
    }
}
