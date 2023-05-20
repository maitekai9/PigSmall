package com.qkk.pigsmall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月20日 10:27:10
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean("pigDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pig")
    public DataSource pigDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("engineDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.engine")
    public DataSource engineDataSource() {
        return DataSourceBuilder.create().build();
    }
}
