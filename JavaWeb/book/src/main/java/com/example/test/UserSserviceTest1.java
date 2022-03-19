package com.example.test;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @create 2021-12-13 10:52
 */
public class UserSserviceTest1 {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser(){  //注册用户
        userService.registUser(new User(null,"格兰尼","123","123"));
    }

    @Test
    public void login(){    //登录
        System.out.println( userService.login(new User(null,"唯","123","234@")));
    }

    @Test
    public void existsUsername(){   //查询用户名是否可用
        if(userService.existsUsername("小优")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}
