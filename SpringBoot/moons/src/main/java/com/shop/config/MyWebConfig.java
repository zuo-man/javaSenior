package com.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    // 配置虚拟路径映射访问
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //获取文件的真实路径
//        String path = System.getProperty("user.dir") + "/moons/src/main/resources/static/imps/";
//
//        //static对应resource下工程目录
//        registry.addResourceHandler("/imps/**").addResourceLocations("file:" + path);
//    }
}
