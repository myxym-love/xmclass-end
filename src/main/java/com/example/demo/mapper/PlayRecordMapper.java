package com.example.demo.mapper;

import com.example.demo.domain.entity.PlayRecord;
import org.springframework.stereotype.Repository;

/**
 * author MaoYu
 * 2021/7/7
 */
@Repository
public interface PlayRecordMapper {

    int saveRecord(PlayRecord playRecord);
}
