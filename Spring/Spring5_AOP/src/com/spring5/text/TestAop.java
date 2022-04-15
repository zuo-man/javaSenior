package com.spring5.text;

import com.spring5.aopnno.User;
import com.spring5.aopxml.Book;
import com.spring5.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    //基于Aspect注解 Aop
    @Test
    public void testAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        User user = context.getBean("user", User.class);

        user.add();
    }

    //基于XML配置文件 Aop
    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopxml.xml");

        Book book = context.getBean("book", Book.class);

        book.buy();
    }

    //完全注解开发
    @Test
    public void testAopConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);

        User user = context.getBean("user", User.class);

        user.add();
    }

}
