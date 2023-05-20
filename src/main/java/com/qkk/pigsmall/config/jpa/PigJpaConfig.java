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
 * @ClassName PigJpaConfig.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月20日 10:47:31
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.qkk.pigsmall.repository.pig"},
        entityManagerFactoryRef = "masterEntityManagerFactory",
        transactionManagerRef = "masterTransactionManager")
public class PigJpaConfig {

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("pigDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .packages("com.qkk.pigsmall.entity.pig")
                .persistenceUnit("master")
                .build();
    }
    @Primary
    @Bean(name = "masterTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory masterEntityManagerFactory) {
        return new JpaTransactionManager(masterEntityManagerFactory);
    }
}
