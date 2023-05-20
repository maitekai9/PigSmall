package com.qkk.pigsmall.mapper.pig;

import com.qkk.pigsmall.entity.pig.GlobalConfig;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName GlobalConfigMapper.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月18日 20:58:19
 */
public interface GlobalConfigMapper {

    List<GlobalConfig> getConfigList();
}
