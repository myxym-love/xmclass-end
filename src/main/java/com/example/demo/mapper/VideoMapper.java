package com.example.demo.mapper;

import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoBanner;
import com.example.demo.domain.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
@Repository
public interface VideoMapper {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(@Param("video_id") int videoId);

    Video findById(@Param("video_id") int videoId);
}
