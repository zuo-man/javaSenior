package com.spring5.text;

import com.spring5.entiy.User;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Spring5 核心容器支持函数式风格 GenericApplicationContext
 *
 * 函数式风格创建对象，交给 spring 进行管理
 */

public class FunctionStyle {
    public static void main(String[] args) {
        //1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2.调用context方法对象进行注册，将new的对象注册到IOC容器中管理
        context.refresh();
        context.registerBean("UserFUN",User.class, () -> new User());

        //3.获取在Spring注册对象
//        User user = (User) context.getBean("com.spring5.entiy.User"); //根据全路径获取对象
        User user = (User) context.getBean("UserFUN");
        System.out.println(user);
    }
}
