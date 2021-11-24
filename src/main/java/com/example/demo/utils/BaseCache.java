package com.example.demo.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * author MaoYu
 * 2021/7/8
 * @author ASUS
 */
@Component
public class BaseCache {

    public  Cache<String,Object> tenMinutesCache = CacheBuilder.newBuilder()

            //缓存初始大小
            .initialCapacity(10)
            //并发数
            .concurrencyLevel(5)
            //最大值
            .maximumSize(100)
            //缓存过期时间,10分钟后过期
            .expireAfterAccess(600, TimeUnit.MINUTES)
            //统计缓存命中率
            .recordStats()

            .build();

    public  Cache<String,Object> oneHourCache = CacheBuilder.newBuilder()

            //缓存初始大小
            .initialCapacity(10)
            //并发数
            .concurrencyLevel(5)
            //最大值
            .maximumSize(100)
            //缓存过期时间,10分钟后过期
            .expireAfterAccess(1, TimeUnit.HOURS)
            //统计缓存命中率
            .recordStats()

            .build();

    public Cache<String, Object> getTenMinutesCache() {
        return tenMinutesCache;
    }

    public void setTenMinutesCache(Cache<String, Object> tenMinutesCache) {
        this.tenMinutesCache = tenMinutesCache;
    }

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }
}
