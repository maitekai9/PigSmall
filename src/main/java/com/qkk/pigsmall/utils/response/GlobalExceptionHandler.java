package com.qkk.pigsmall.utils.response;

import com.qkk.pigsmall.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月19日 22:04:10
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = PigException.class)
    public ResponseEntity<Map<String, Object>> handler(HttpServletRequest request, PigException e) {
        log.error(String.format("call url: %s failed, error: %s", request.getRequestURI(), e.getMessage()));
        return Result.buildFailed(request, e);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, Object>> handler(HttpServletRequest request, Exception e) {
        log.error(String.format("call url: %s failed, error: %s", request.getRequestURI(), e.getMessage()));
        return Result.buildFailed(request, e.getMessage());
    }
}
