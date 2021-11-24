package com.example.demo.service;

import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoBanner;

import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
