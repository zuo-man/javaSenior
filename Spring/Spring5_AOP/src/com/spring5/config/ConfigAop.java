package com.spring5.config;

import org.springframework.context.annotation.*;

//完全注解开发
/**
 * @Configuration ：作为配置类，替代 XML 配置文件
 * @ComponentScan ：(basePackages = {"com.spring5"})  ：开启组件扫描，扫描包上层目录com.spring5，下层目录的注解都会扫描到
 * @EnableAspectJAutoProxy ：开启Aspect生成代理对象 ，默认是true开启的
 */
@Configuration
@ComponentScan(basePackages ="com.spring5")
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class ConfigAop {
}
