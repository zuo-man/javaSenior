package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.cloud.dao")
public class PaymentMain8002 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8002.class, args);
    }
}
