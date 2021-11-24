package com.example.demo.mapper;

import com.example.demo.domain.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
@Repository
public interface VideoOrderMapper {

    VideoOrder findByUserIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    int saveOrder(VideoOrder videoOrder);


    List<VideoOrder> listOrder(@Param("user_id") Integer userId);
}
