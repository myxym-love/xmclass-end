package com.example.demo.service;

import com.example.demo.domain.entity.User;

import java.util.Map;

/**
 * author MaoYu
 * 2021/7/6
 */
public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String,String> userInfo);


    String findByPhoneAndPwd(String phone, String pwd);

    User findByUserId(Integer user_id);
}
