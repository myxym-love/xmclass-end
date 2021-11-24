package com.example.demo.exception;

/**
 * author MaoYu
 * 2021/7/7
 */

/**
 * 自定义异常类
 */
public class XDException extends RuntimeException{

    private Integer code;

    private String msg;

    public XDException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
