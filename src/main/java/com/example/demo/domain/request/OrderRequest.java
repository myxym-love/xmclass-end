package com.example.demo.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * author MaoYu
 * 2021/7/7
 */
public class OrderRequest {

    @JsonProperty("video_id")
    private Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
