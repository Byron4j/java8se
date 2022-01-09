package org.byron4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.byron4j.mapper")
public class StartupApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class);
    }
}
