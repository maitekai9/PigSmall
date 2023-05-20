package com.qkk.pigsmall.config.jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @ClassName EngineJpaConfig.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月20日 10:47:16
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.qkk.pigsmall.repository.engine"},
        entityManagerFactoryRef = "engineEntityManagerFactory",
        transactionManagerRef = "engineTransactionManager")
public class EngineJpaConfig {

    @Bean(name = "engineEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("engineDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .packages("com.qkk.pigsmall.entity.engine")
                .persistenceUnit("engine")
                .build();
    }

    @Bean(name = "engineTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("engineEntityManagerFactory") EntityManagerFactory engineEntityManagerFactory) {
        return new JpaTransactionManager(engineEntityManagerFactory);
    }
}
