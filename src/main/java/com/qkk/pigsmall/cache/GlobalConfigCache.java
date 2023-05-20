package com.qkk.pigsmall.cache;

import com.qkk.pigsmall.entity.pig.GlobalConfig;
import com.qkk.pigsmall.repository.pig.GlobalConfigRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GlobalConfigCache extends BaseCache<String, GlobalConfig> {
    @Resource
    GlobalConfigRepository globalConfigRepository;

    @Override
    protected int getCacheSize() {
        return 100;
    }

    @Override
    protected GlobalConfig initBaseObject(String name) {

        return globalConfigRepository.findByName(name);
    }

    public GlobalConfig getByName(String name) {
        return get(name);
    }
}
