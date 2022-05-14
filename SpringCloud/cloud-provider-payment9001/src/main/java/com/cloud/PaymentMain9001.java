package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

//微服务注册
@EnableDiscoveryClient
public class PaymentMain9001 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain9001.class, args);
    }
}
