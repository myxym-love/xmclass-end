package com.example.demo.exception;

import com.example.demo.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author MaoYu
 * 2021/7/7
 */

@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e) {

        if(e instanceof XDException) {

            logger.error("[ 系统异常 ]{}",e);

            XDException XDException = (XDException) e;
            return JsonData.buildError(XDException.getCode(), XDException.getMsg());
        }
        else {
            return JsonData.buildError("全局异常，未知错误");
        }
    }

}
