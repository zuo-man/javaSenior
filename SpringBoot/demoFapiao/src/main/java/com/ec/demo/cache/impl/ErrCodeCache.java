package com.ec.demo.cache.impl;

import com.ec.demo.cache.ErrorCache.ErrorEntry;
import com.ec.demo.cache.ICache;
import com.ec.demo.enums.CacheRefreshType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrCodeCache implements ICache<ErrorEntry> {

    private final Logger logger = LoggerFactory.getLogger(ErrCodeCache.class);


    @Override
    public Class<?> getCacheObjectType() {
        return ErrCodeCache.class;
    }

    @Override
    public Map<String, ErrorEntry> cacheObject(BigDecimal acDate) {
        return null;
    }

    @Override
    public Map<String, ErrorEntry> cacheObject() {
        //查数据库查所有，得到list集合
        List<ErrorEntry> errorCodeList = null;
        Map<String,ErrorEntry> cacheMap = new HashMap<>();
        for(ErrorEntry errorEntry : errorCodeList){
            cacheMap.put(errorEntry.getErrCode(),errorEntry);
        }
        logger.debug("{}",cacheMap);
        return cacheMap;
    }

    @Override
    public Boolean checkCachRefreshPolicy(CacheRefreshType refreshType) {
        return CacheRefreshType.HOUR.equals(refreshType);
    }
}
