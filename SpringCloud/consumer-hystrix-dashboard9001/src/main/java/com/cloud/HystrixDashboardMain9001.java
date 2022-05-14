package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication

// hystrix图形化界面
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }

}
