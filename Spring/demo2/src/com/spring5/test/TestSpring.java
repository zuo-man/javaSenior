package com.spring5.test;

import com.spring5.aut.User;
import com.spring5.collection.*;
import com.spring5.life.Orders;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2022-02-26 14:16
 */
public class TestSpring {
    //集合类型属性注入
    @Test
    public void testStudent(){
        ApplicationContext context = new ClassPathXmlApplicationContext("stu.xml");

        Student student = context.getBean("student", Student.class);

        student.test();
    }

    //提取list集合类型属性注入
    @Test
    public void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("extract.xml");

        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);

        book1.show();

        System.out.println(book1);
        System.out.println(book2);
    }

    //测试bean自动装配
    @Test
    public void testAut(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aut.xml");

        User user = context.getBean("user", User.class);

        System.out.println(user);
    }

    //工厂bean
    @Test
    public void testFac(){
        ApplicationContext context = new ClassPathXmlApplicationContext("fac.xml");

        Teacher teacher = context.getBean("myBean", Teacher.class);

        System.out.println(teacher);
    }

    //测试bean生命周期
    @Test
    public void testLife(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("life.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("life.xml");

        Orders orders = context.getBean("orders", Orders.class);

        System.out.println("第四步 获取创建bean实例对象");
        System.out.println(orders);

        //手动让bean实例销毁，否则不会执行销毁方法， classPath是Application的子类，也可以转型
        context.close();
    }
}
