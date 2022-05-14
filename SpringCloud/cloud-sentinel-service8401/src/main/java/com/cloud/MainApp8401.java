package com.cloud;

import com.alibaba.csp.sentinel.transport.config.TransportConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

//开启注册
@EnableDiscoveryClient
public class MainApp8401 {
    public static void main(String[] args) {
        // Linux下Docker模式运行Sentinel时使用下面这行代码，Windows跟macOS下运行Sentinel不要使用59.54.62.38
//        System.setProperty(TransportConfig.HEARTBEAT_CLIENT_IP, "192.168.31.168");
        // 下面这种方式好像不行
        // System.setProperty(TransportConfig.HEARTBEAT_CLIENT_IP, IPUtils.getOutIPV4());

        SpringApplication.run(MainApp8401.class, args);
    }
}
