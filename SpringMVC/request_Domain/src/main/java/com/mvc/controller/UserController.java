package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    /**
     * 使用RESTFul模拟用户资源的增删改查
     * GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE用来删除资源。
     *
     * /user      GET     查询所有用户信息
     * /user/1    GET     根据用户id查询用户信息
     * /user      POST    添加用户信息
     * /user/1    DELECT  删除用户信息
     * /user      PUT     修改用户信息
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("根据ID查询用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password){
        System.out.println("添加用户信息： 用户名：" + username + "，密码：" + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password){
        System.out.println("添加用户信息： 用户名：" + username + "，密码：" + password);
        return "success";
    }
}
