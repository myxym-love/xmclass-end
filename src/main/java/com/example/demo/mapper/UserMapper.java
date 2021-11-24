package com.example.demo.mapper;

import com.example.demo.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * author MaoYu
 * 2021/7/6
 */
@Repository
public interface UserMapper {


    int  save(User user);

    int findByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findByUserId(@Param("user_id") Integer user_id);
}
