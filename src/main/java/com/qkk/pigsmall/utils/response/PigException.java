package com.qkk.pigsmall.utils.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PigException.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月19日 21:55:53
 */
public class PigException extends Exception{
    private final ErrorCode errorCode;
    public PigException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public Map<String, Object> format() {
        Map<String, Object> res = new HashMap<>();
        res.put("status", errorCode.getStatus());
        res.put("error", errorCode.getError());
        res.put("message", errorCode.getMessage());
        return res;
    }
}
