package com.boot.config;

import com.boot.interceptor.LoginInterceptor;
import com.boot.interceptor.RedisUrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @EnableWebMvc ： 全面接管 MVC
 *      1.静态资源、视图解析器、欢迎页。。。全部失效，需要自己去配置，建议不用
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {       //定制 web功能
    /**
     * Filter、Interceptor 拦截器几乎拥有相同的功能，区别？
     * 1. Filter是Servlet定义的源生组件，好处：脱离spring应用也能使用
     * 2.Interceptor是Spring定义的接口，可以使用Spring的自动装配等功能
     */

    //获取容器中配置好的 RedisUrlInterceptor拦截器
    @Autowired
    RedisUrlInterceptor redisUrlInterceptor;

    /**
     * 拦截器工作：
     * 1.编写一个拦截器实现HandlerInterceptor接口  --> LinginIntercepter
     * 2.拦截器注册到容器中（实现WebMvcConfigurer的addIntercepotors）
     * 3.指定拦截规则【若是拦截所有请求，静态资源也会被拦截】
     */
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //登录拦截器             new：此拦截器没有注入到容器中，也就是@Component
        registry.addInterceptor(new LoginInterceptor())
                 .addPathPatterns("/**")               //  /**：拦截所有请求，包括静态资源
                                                        //放行的请求
                 .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");

        //计算访问量拦截器      没有new：此拦截器注入到了容器中，可以@Autowired拿出来
        registry.addInterceptor(redisUrlInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");

    }




    //定制化web功能，bean给容器中扩展一些组件
//    @Bean
}
