package com.example.colorclub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync//允许异步任务
@EnableScheduling//开启定时任务
@SpringBootApplication
public class colorclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(colorclubApplication.class, args);
    }

}
