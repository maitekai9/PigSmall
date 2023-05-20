package com.qkk.pigsmall.repository.pig;

import com.qkk.pigsmall.entity.pig.GlobalConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName GlobalConfigRepository.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月18日 21:41:01
 */
public interface GlobalConfigRepository extends JpaRepository<GlobalConfig, Long> {
    GlobalConfig findByName(String name);
}
