package com.qkk.pigsmall.mapper;

import com.qkk.pigsmall.entity.GlobalConfig;
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
    @Select(value = "select id, name, value, create_time as createTime, modify_time as modifyTime, is_deleted as isDeleted from global_config")
    List<GlobalConfig> selectConfigList();
}
