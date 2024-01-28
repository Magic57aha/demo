package com.example.firstspringboot.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
/**
 * @author code羊
 * @date 2024/1/20 16 49
 * discription
 */
@Configuration
@MapperScan("com.example.firstspringboot.mapper") // 指定Mapper接口的扫描路径
public class ApplicationConfig {
    // 这里可以添加其他MyBatis配置
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/mappers/*.xml"));
        return factoryBean.getObject();
    }

    // 配置数据源
    @Bean
    public DataSource dataSource() {
        // 使用Spring Boot提供的DataSourceBuilder来创建数据源
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:~/magic")
                .username("")
                .password("")
                .build();
    }
}