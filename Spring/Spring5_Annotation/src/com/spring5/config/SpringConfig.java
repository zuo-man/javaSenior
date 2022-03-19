package com.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//完全注解开发
/**
 * @Configuration： 作为配置类，替代 XML 配置文件
 * @ComponentScan (basePackages = {"com.spring5"})  ：开启组件扫描，扫描包上层目录com.spring5，下层目录的注解都会扫描到
 */
@Configuration
@ComponentScan(basePackages ="com.spring5")

public class SpringConfig {

}
