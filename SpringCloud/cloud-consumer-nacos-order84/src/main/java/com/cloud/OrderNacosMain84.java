package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@EnableDiscoveryClient

//激活 OpenFeign
@EnableFeignClients
public class OrderNacosMain84 {
    public static void main(String[] args) {

        SpringApplication.run(OrderNacosMain84.class, args);
    }
}
