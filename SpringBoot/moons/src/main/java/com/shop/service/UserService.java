package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* @author shengda
* @description 针对表【user】的数据库操作Service
* @createDate 2022-04-19 10:44:41
*/
public interface UserService extends IService<User> {

    //根据用户名 密码查询数据 ，返回User 对象
    User loginByUsernameAndByPassword(String username,String password);

    User getUsername(String username);

    //模糊查询
    Page<User> getUsernameAndRoleName(Page<User> page, String username, String roleName);
}
