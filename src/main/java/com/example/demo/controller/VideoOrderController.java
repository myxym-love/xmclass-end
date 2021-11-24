package com.example.demo.controller;

import com.example.demo.domain.entity.Video;
import com.example.demo.domain.entity.VideoOrder;
import com.example.demo.domain.request.OrderRequest;
import com.example.demo.service.VideoOrderService;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author MaoYu
 * 2021/7/7
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    VideoOrderService videoOrderService;


    /**
     * 下单接口
     * @param orderRequest
     * @param request
     * @return
     */
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody OrderRequest orderRequest, HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");

        int rows = videoOrderService.save(userId,orderRequest.getVideoId());
        return rows == 0 ? JsonData.buildError("您已经购买过") : JsonData.buildSuccess();

    }

    /**
     * 订单列表
     * @param request
     * @return
     */
    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrder(userId);

        return JsonData.buildSuccess(videoOrderList);
    }
}
