package com.java.spring.service;

import com.java.spring.dao.UserDao;
import com.java.spring.dao.UserDaoImpl;

/**
 * @create 2022-02-26 12:48
 */
public class UserService {

    //创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add...");

        userDao.update();

        //第一种，原始方式创建UserDao对象
//        UserDao userDao = new UserDaoImpl();
//        userDao.update();
    }
}
