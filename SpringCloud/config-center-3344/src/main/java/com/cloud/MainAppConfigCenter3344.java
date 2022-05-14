package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

//config 配置中心
@EnableConfigServer
public class MainAppConfigCenter3344 {
    public static void main(String[] args) {

        SpringApplication.run(MainAppConfigCenter3344.class, args);
    }
}
