package com.example.demo.mapper;

import com.example.demo.domain.entity.Episode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * author MaoYu
 * 2021/7/7
 */
@Repository
public interface EpisodeMapper {

    Episode findEpisodeByVideoId(@Param("video_id") int videoId);
}
