package com.example.demo.controller;

import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoBanner;
import com.example.demo.service.VideoService;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    /**
     * 轮播图接口
     * @return
     */
    @GetMapping("list_banner")
    public JsonData listBanner() {
        List<VideoBanner> videoBannerList = videoService.listBanner();

        return JsonData.buildSuccess(videoBannerList);
    }

    /**
     *视频列表接口
     * @return
     */
    @GetMapping("list")
    public JsonData listVideo() {
        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }

    /**
     * 视频详情接口
     * @param videoId
     * @return
     */
    @GetMapping("list_detail")
    public JsonData listVideoDetailById(@RequestParam(value = "video_id",required = true)int videoId) {

        Video video = videoService.findDetailById(videoId);

        return JsonData.buildSuccess(video);
    }
}
