package com.spring5.test;

import com.spring5.config.SpringConfig;
import com.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnn {

    //IOC容器
    @Test
    public void testService(){
        //加载配置类
        ApplicationContext context = new ClassPathXmlApplicationContext("Ann.xml");

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);

        userService.add();
    }

    //完全注解开发
    @Test
    public void testConfig(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);

        userService.add();
    }
}
