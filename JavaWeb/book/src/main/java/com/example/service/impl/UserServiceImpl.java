package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import com.example.service.UserService;

/**
 * @create 2021-12-13 10:34
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();  //调用数据库等操作，userDao已经执行，不需要重新extends于BaseDao

    @Override
    public void registUser(User user) { //保存
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) { //登录
        return userDao.queryUserByUsernamePassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) { //根据用户名查询
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
