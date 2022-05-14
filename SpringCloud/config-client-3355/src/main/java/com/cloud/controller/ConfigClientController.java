package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

/**
 * git更改yml文件后，3344立刻获取，但是3355获取不到
 * @RefreshScope : 动态刷新，获取更改的配置
 * 但是需要发送 Post请求刷新3355才会生效
 *            curl -X POST "http://localhost:3355/actuator/refresh"
 */
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){

        return configInfo;
    }
}
