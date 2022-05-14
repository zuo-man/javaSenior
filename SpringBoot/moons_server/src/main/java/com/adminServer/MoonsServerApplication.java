package com.adminServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableAdminServer : 开启服务器监控功能
 */

@EnableAdminServer
@SpringBootApplication
public class MoonsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonsServerApplication.class, args);
    }

}
