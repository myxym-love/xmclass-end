package com.example.demo.config;

/**
 * author MaoYu
 * 2021/7/8
 */
public class CacheKeyManager {

    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:video:banner";
    /**
     * 首页视频列表缓存key
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";
    /**
     * 视频详情缓存key,%s是视频id
     */
    public static final String VIDEO_DETAIL = "index:detail:%s";
}
