package com.example.dao;

import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import org.junit.Test;

/**
 * @create 2021-12-12 13:54
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username  用户名，返回为null，则没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名密码查询用户信息
     * @param username  返回为null，说明用户名或密码错误
     */
    public User queryUserByUsernamePassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     */
    public int saveUser(User user);

}
