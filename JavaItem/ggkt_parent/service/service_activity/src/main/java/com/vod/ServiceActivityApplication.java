package com.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
//@ComponentScan(basePackages = "com.vod")

//openFeign
@EnableFeignClients(basePackages = "com.client")

public class ServiceActivityApplication {
    public static void main(String[] args) {

        SpringApplication.run(ServiceActivityApplication.class, args);
    }
}
