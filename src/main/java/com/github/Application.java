package com.github;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 *
 * @author wulitech
 * @version 1.0
 */
@SpringBootApplication
@MapperScans({@MapperScan("com.github.core.mapper"), @MapperScan("com.github.mapper")})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

