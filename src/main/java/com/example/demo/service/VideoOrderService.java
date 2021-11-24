package com.example.demo.service;

import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoOrder;

import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
public interface VideoOrderService {

    int save(int userId, int videoId);

    List<VideoOrder> listOrder(Integer userId);
}
