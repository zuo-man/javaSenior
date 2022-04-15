package com.plusX.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plusX.pojo.User;
import com.plusX.service.UserService;
import com.plusX.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Dell
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-04-15 15:35:05
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAgeUserName(Integer age, String userName) {
        return userMapper.selectByAgeAndUserName(age, userName);
    }
}




