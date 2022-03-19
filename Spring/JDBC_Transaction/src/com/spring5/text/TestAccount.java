package com.spring5.text;

import com.spring5.config.TxConfig;
import com.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    //基于注解方式实现事务操作
    @Test
    public void testAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("druid.xml");

        UserService userService = context.getBean("userService", UserService.class);

        userService.account();
    }

    //完全注解声明式事务管理
    @Test
    public void testAnn(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        userService.account();
    }

    //基于XML文件配置实现事务操作
    @Test
    public void testXMLAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("druidXML.xml");

        UserService userService = context.getBean("userService", UserService.class);

        userService.account();
    }

}
