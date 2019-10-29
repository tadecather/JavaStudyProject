package com.taaaaad.exception;


/**
 * 自定义异常
 */
public class SysException extends Exception {

    // 存储异常信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
