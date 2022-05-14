package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

//微服务注册
@EnableDiscoveryClient
public class PaymentMain9002 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain9002.class, args);
    }
}