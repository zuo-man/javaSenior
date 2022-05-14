package com.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.storage.mapper")
@SpringBootApplication
public class StorageApplication {
    public static void main(String[] args) {

        SpringApplication.run(StorageApplication.class, args);
    }

}
