package com.qkk.pigsmall.service;

import com.qkk.pigsmall.cache.GlobalConfigCache;
import com.qkk.pigsmall.entity.pig.GlobalConfig;
import com.qkk.pigsmall.mapper.pig.GlobalConfigMapper;
import com.qkk.pigsmall.repository.pig.GlobalConfigRepository;
import com.qkk.pigsmall.utils.Constant;
import com.qkk.pigsmall.utils.response.ErrorCode;
import com.qkk.pigsmall.utils.response.PigException;
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
        List<GlobalConfig> globalConfigs = globalConfigMapper.selectConfigList();
        Map<String, Object> data = new HashMap<>();
        data.put(Constant.ITEMS, globalConfigs);
        return data;
    }

    public Map<String, Object> query(String name) throws PigException {
        Map<String, Object> data = new HashMap<>();
        GlobalConfig globalConfig = globalConfigCache.getByName(name);
        if (globalConfig == null) {
            throw new PigException(ErrorCode.GLOBAL_CONFIG_NOT_EXISTS);
        }
        data.put(Constant.ITEMS, globalConfig);
        return data;
    }
}
