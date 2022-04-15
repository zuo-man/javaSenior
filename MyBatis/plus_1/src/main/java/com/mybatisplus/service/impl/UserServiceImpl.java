package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.pojo.User;
import com.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 因为 IService实现了很多方法，所以本类页需要实现IServiece所有方法，这时需要ServiceImpl
 * ServiceImpl<> ：最顶级IService的实现类
 *                  < 泛型：M 是mapper对象， T 是实体 >
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //调用UserMapper自定义方法
    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> selectMap(Long id) {
        return userMapper.selectMapById(id);
    }
}
