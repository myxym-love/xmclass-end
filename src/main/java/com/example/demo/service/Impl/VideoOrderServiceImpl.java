package com.example.demo.service.Impl;

import com.example.demo.domain.entity.Episode;
import com.example.demo.domain.entity.PlayRecord;
import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoOrder;
import com.example.demo.exception.XDException;
import com.example.demo.mapper.EpisodeMapper;
import com.example.demo.mapper.PlayRecordMapper;
import com.example.demo.mapper.VideoMapper;
import com.example.demo.mapper.VideoOrderMapper;
import com.example.demo.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * author MaoYu
 * 2021/7/7
 */
@Service
@Transactional
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    VideoOrderMapper videoOrderMapper;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    EpisodeMapper episodeMapper;

    @Autowired
    PlayRecordMapper playRecordMapper;

    @Override
    public int save(int userId, int videoId) {
        /**
         * 判断是否已购买
         */
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndState(userId,videoId,1);
        if (videoOrder != null){return 0;}

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        if(rows == 1 ){
            Episode episode = episodeMapper.findEpisodeByVideoId(videoId);
            if(episode == null){
                throw new XDException(-1,"视频没有集信息");
            }

            PlayRecord playRecord = new PlayRecord();

            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setVideoId(episode.getVideoId());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);

            playRecordMapper.saveRecord(playRecord);

        }

        return rows;
    }

    @Override
    public List<VideoOrder> listOrder(Integer userId) {
        return videoOrderMapper.listOrder(userId);
    }
}
