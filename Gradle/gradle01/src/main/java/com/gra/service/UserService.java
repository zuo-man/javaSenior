package com.gra.service;

import com.gra.bean.User;
import com.gra.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public List<User> getUserList(){
        return userMapper.getUserList();
    }
}
