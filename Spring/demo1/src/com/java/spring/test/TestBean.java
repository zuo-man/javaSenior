package com.java.spring.test;

import com.java.spring.bean.Emp;
import com.java.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2022-02-26 13:10
 */
public class TestBean {
    @Test
    public void testAdd(){
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        //2.获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void testEmp(){
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        //2.获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.add();
    }
}
