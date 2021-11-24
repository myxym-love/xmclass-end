package com.example.demo.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author MaoYu
 * 2021/7/8
 */
public class CorsInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));

        response.setHeader("Access-Control-Allow-Credentials","true");

        response.setHeader("Access-Control-Allow-Methods","GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");

        response.setHeader("Access-Control-Allow-Headers","*");

        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
