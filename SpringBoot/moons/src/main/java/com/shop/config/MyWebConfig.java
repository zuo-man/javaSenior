package com.shop.config;

import com.shop.interceptor.UrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {


    //获取容器中配置好的 UrlInterceptor拦截器
//    @Autowired
//    UrlInterceptor urlInterceptor;
//
//    /**
//     * 拦截器工作：
//     * 1.编写一个拦截器实现HandlerInterceptor接口  --> LinginIntercepter
//     * 2.拦截器注册到容器中（实现WebMvcConfigurer的addIntercepotors）
//     * 3.指定拦截规则【若是拦截所有请求，静态资源也会被拦截】
//     */
//    //添加拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        //计算访问量拦截器 ，redis存储
//        registry.addInterceptor(urlInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/user/test", "/user/**", "/index/login");
//
//    }


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
