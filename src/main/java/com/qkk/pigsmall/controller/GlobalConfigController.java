package com.qkk.pigsmall.controller;

import com.qkk.pigsmall.service.GlobalConfigService;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    Object queryAll() {
        return globalConfigService.getList();
    }

    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    Object query(String name) {
        return globalConfigService.query(name);
    }
}
