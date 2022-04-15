package com.plus;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.plus.mapper")
public class Plus2DatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Plus2DatasourceApplication.class, args);
    }

}
