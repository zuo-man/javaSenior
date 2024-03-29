package com.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

//pom引入模块后，还需要导入 路径包
//@ComponentScan(basePackages = "com.vod")

//开启注册功能
@EnableDiscoveryClient

public class ServiceVodApplication {
    public static void main(String[] args){

        SpringApplication.run(ServiceVodApplication.class);

    }
}
