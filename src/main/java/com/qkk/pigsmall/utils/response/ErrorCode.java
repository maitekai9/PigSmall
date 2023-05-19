package com.qkk.pigsmall.utils.response;

import org.springframework.http.HttpStatus;

/**
 * @ClassName ErrorCode.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月19日 21:40:09
 */
public enum ErrorCode {
    GLOBAL_CONFIG_NOT_EXISTS(HttpStatus.BAD_REQUEST.value(), "Config.NotFound", "global config is not exist.");
    private final Integer status;
    private final String error;
    private final String message;

    ErrorCode(Integer status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
