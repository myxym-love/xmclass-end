package com.example.demo.service.Impl;

import com.example.demo.config.CacheKeyManager;
import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoBanner;
import com.example.demo.mapper.VideoMapper;
import com.example.demo.service.VideoService;
import com.example.demo.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;


    @Override
    public List<Video> listVideo() {

        try {

            Object cacheVideoList = baseCache.getTenMinutesCache().get(CacheKeyManager.INDEX_VIDEO_LIST,() -> {

                List<Video> videoList = videoMapper.listVideo();
                System.out.println("从数据库拿视频列表数据");
                return videoList;
            });

            if(cacheVideoList instanceof List) {
                List<Video> videoList = (List<Video>) cacheVideoList;
                return videoList;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {

        try {

            Object cacheBanner = baseCache.getTenMinutesCache().get(CacheKeyManager.INDEX_BANNER_KEY,() -> {
                List<VideoBanner> bannerList = videoMapper.listBanner();
                System.out.println("从数据库里拿轮播图数据");
                return bannerList;
            });

            if (cacheBanner instanceof List) {
                List<VideoBanner> bannerList =(List<VideoBanner>) cacheBanner;
                return bannerList;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        try {

            String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);
            Object cacheVideoDetail = baseCache.getOneHourCache().get(videoCacheKey,() -> {

                Video video = videoMapper.findDetailById(videoId);
                System.out.println("从数据库拿视频详情数据");
                return video;
            });
            if (cacheVideoDetail instanceof Video) {
                Video video = (Video) cacheVideoDetail;
                return video;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
