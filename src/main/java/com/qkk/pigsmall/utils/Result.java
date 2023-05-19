package com.qkk.pigsmall.utils;

import com.qkk.pigsmall.utils.response.PigException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Result.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月19日 21:45:13
 */
public class Result {
    public static ResponseEntity<Map<String, Object>> buildSuccess(HttpServletRequest request, Map<String, Object> data) {
        Map<String, Object> item = new HashMap<>();
        item.put("status", HttpStatus.OK.value());
        item.put("error", Constant.OK);
        item.put("message", Constant.SUCCESS);
        if (data != null && !data.isEmpty()) {
            item.put("data", data);
        }
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> buildFailed(HttpServletRequest request, PigException e) {
        return new ResponseEntity<>(e.format(), HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> buildFailed(HttpServletRequest request, String message) {
        Map<String, Object> item = new HashMap<>();
        item.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        item.put("error", "Internal.ServerError");
        item.put("message", Constant.FAILED);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
