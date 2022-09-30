package com.boot;

import tk.mybatis.spring.annotation.MapperScan;;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boot.mapper")
public class DockerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerTestApplication.class, args);
    }

}
