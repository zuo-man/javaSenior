package com.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//扫描 mapper接口所在的包
@MapperScan("com.mybatisplus.mapper")
public class Plus1Application {

    public static void main(String[] args) {
        SpringApplication.run(Plus1Application.class, args);
    }

}
