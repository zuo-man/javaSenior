package com.mybais.mapper;

import com.mybais.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    //添加用户信息
    int inserUser(User user);

    //根据用户名查询用户信息
    User getUserByUsername(String username);

    //验证登录（使用@Param）
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    //验证登录
    User checkLogin(String username, String password);

    //验证登录（集合）
    User checkLoginByMap(Map<String, Object> map);

    //查询所有员工信息
    List<User> getAllUser();


}
