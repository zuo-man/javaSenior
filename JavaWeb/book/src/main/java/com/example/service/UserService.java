package com.example.service;

import com.example.pojo.User;

/**
 * @create 2021-12-13 10:28
 */
public interface UserService {
    /**
     * 注册用户
     */
    public void registUser(User user);

    /**
     * 登录
     * @return  返回null，说明登录失败，返回有值，登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @return  返回True表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
