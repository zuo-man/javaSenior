package com.boot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//自动配置，将会扫描com.boot 包下的所有注解，要注意application的存放位置
@SpringBootApplication

/**
 * @ServletComponentScan： 指定源生Servlet组件都放在哪里
 *           Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册
 *
 * @MapperScan： 扫描自定包下的Mapper组件，mapper包下的就不用每个都标注@mapper
 *
 * @SpringBootApplication(exclude = xxx.class)：表示排除xxx的全部自动配置
 */
@ServletComponentScan(basePackages = "com.boot")
@MapperScan("com.boot.mapper")
//@SpringBootApplication(exclude = xxx.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
