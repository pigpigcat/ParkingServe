package com.github.core.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Mybatis插件配置类
 *
 * @author wulitech
 * @version 1.0
 */
@Configuration
public class MybatisConfig {

    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public MybatisConfig(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @PostConstruct
    public void initMybatisPlugins() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("autoRuntimeDialect", "true");
        properties.setProperty("params", "count=countSql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(pageInterceptor);
    }

}
