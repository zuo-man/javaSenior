package com.plus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plus.mapper.UserMapper;
import com.plus.pojo.User;
import com.plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * User表在 master中
 */

@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
