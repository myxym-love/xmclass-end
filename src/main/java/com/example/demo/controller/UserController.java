package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.LoginRequest;
import com.example.demo.service.UserService;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * author MaoYu
 * 2021/7/7
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 注册接口
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败");
    }

    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.buildError("账号密码错误") : JsonData.buildSuccess(token);
    }

    /**
     * 查询用户信息接口
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){
        Integer user_id = (Integer) request.getAttribute("user_id");
        if(user_id == null){
            return JsonData.buildError("查询失败");
        }
        User user = userService.findByUserId(user_id);
        return JsonData.buildSuccess(user);
    }
}
