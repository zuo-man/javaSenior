package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;

/**
 * @create 2021-12-12 14:02
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? ";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernamePassword(String username, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
