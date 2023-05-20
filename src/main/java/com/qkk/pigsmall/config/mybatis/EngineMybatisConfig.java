package com.qkk.pigsmall.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @ClassName EngineMybatisConfig.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月20日 10:42:28
 */
@Configuration
@MapperScan(basePackages = "com.qkk.pigsmall.mapper.engine", sqlSessionFactoryRef = "engineSqlSessionFactory")
public class EngineMybatisConfig {
    @Bean("engineSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("engineDataSource") DataSource dataSource) throws Exception {
        // 设置数据源
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mapper的xml文件位置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String locationPattern = "classpath*:/mapper/engine/*.xml";
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));
        //对应数据库的entity位置
        String typeAliasesPackage = "com.qkk.pigsmall.entity.engine";
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean.getObject();
    }
}
