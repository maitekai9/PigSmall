package com.qkk.pigsmall.controller;

import com.qkk.pigsmall.service.GlobalConfigService;
import com.qkk.pigsmall.utils.Result;
import com.qkk.pigsmall.utils.response.PigException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName GlobalConfigController.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月18日 21:07:30
 */
@RestController
@RequestMapping("/api/v1/global/config")
public class GlobalConfigController {
    @Resource
    GlobalConfigService globalConfigService;

    @RequestMapping(value = "/queryAll", method = {RequestMethod.GET, RequestMethod.POST})
    ResponseEntity<Map<String, Object>> queryAll(HttpServletRequest request) {
        return Result.buildSuccess(request, globalConfigService.getList());
    }

    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    ResponseEntity<Map<String, Object>> query(HttpServletRequest request, @RequestParam() String name) throws PigException {
        return Result.buildSuccess(request, globalConfigService.query(name));
    }
}
