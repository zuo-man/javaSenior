package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.pojo.User;
import com.shop.service.UserService;
import com.shop.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shengda
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-04-19 10:44:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    //根据用户名 密码查询数据 ，返回User 对象
    @Override
    public User loginByUsernameAndByPassword(String username, String password) {
        return userMapper.selectByUsernameAndByPassword(username, password);
    }

    @Override
    public User getUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public Page<User> getUsernameAndRoleName(Page<User> page, String username, String roleName) {
        return userMapper.selectByUsernameOrByRoleName(page, username, roleName);
    }
}




