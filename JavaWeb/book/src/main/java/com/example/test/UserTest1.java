package com.example.test;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import org.junit.Test;

/**
 * @create 2021-12-12 15:08
 */
public class UserTest1 {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernamePassword(){
        if(userDao.queryUserByUsernamePassword("小优","123") == null){
            System.out.println("用户名或密码错误");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser(){
        System.out.println( userDao.saveUser(new User(null,"无暇","234","wer@")));
    }
}
