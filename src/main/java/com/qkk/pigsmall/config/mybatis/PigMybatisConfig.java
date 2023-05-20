package com.qkk.pigsmall.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @ClassName PigMybatisConfig.java
 * @Author Maitekai
 * @Version 1.0.0
 * @Description
 * @CreateTime 2023年05月20日 10:36:22
 */
@Configuration
@MapperScan(basePackages = "com.qkk.pigsmall.mapper.pig", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class PigMybatisConfig {
    @Primary
    @Bean("masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("pigDataSource") DataSource dataSource) throws Exception {
        // 设置数据源
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mapper的xml文件位置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String locationPattern = "classpath*:/mapper/pig/*.xml";
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));
        //对应数据库的entity位置
        String typeAliasesPackage = "com.qkk.pigsmall.entity.pig";
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean.getObject();
    }
}
