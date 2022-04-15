package com.plusX;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.plusX.mapper")
public class Plus3XApplication {

    public static void main(String[] args) {
        SpringApplication.run(Plus3XApplication.class, args);
    }

}
