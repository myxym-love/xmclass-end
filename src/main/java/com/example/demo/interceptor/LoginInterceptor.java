package com.example.demo.interceptor;

import com.example.demo.utils.JWTUtils;
import com.example.demo.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * author MaoYu
 * 2021/7/7
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {

            String accesstoken = request.getHeader("token");
            if(accesstoken == null){
                accesstoken = request.getParameter("token");
            }

            if(StringUtils.isNotBlank(accesstoken)){
                Claims claims = JWTUtils.checkJWT(accesstoken);
                if(claims == null){
                    sendjsonMessage(response, JsonData.buildError("登录过期，重新登录"));
                    return false;

                }

                Integer id = (Integer)claims.get("id");
                String name = (String)claims.get("name");

                request.setAttribute("user_id",id);
                request.setAttribute("name",name);
                return true;
            }


        }catch (Exception e){

        }
        sendjsonMessage(response, JsonData.buildError("登录失败，重新登录"));
        return false;
    }

    public static void sendjsonMessage(HttpServletResponse response, Object obj){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
