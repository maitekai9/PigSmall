package com.qkk.pigsmall.service;

import com.qkk.pigsmall.cache.GlobalConfigCache;
import com.qkk.pigsmall.entity.GlobalConfig;
import com.qkk.pigsmall.mapper.GlobalConfigMapper;
import com.qkk.pigsmall.repository.GlobalConfigRepository;
import com.qkk.pigsmall.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GlobalConfigService.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月18日 21:04:25
 */
@Service
public class GlobalConfigService {
    @Resource
    GlobalConfigMapper globalConfigMapper;
    @Resource
    GlobalConfigRepository globalConfigRepository;
    @Resource
    GlobalConfigCache globalConfigCache;

    public Map<String, Object> getList() {
        List<GlobalConfig> globalConfigs = globalConfigRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put(Constant.DATA, globalConfigs);
        return data;
    }

    public Map<String, Object> query(String name) {
        Map<String, Object> data = new HashMap<>();
        data.put(Constant.DATA, globalConfigCache.getByName(name));
        return data;
    }
}
