package la.chopper.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
@SpringBootApplication
@MapperScans({@MapperScan("la.chopper.spring.boot.core.mapper"), @MapperScan("la.chopper.spring.boot.mapper")})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

