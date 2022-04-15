package com.mybais.mapper;

import com.mybais.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    //根据id查询用户信息
    List<User> getUserById(@Param("id") Integer id);
//    或者：User getUserById(@Param("id") Integer id);

    //根据id查询用户信息为一个map集合
    Map<String, Object> getUserByIdMap(@Param("id") Integer id);

    //查询用户信息的总记录数
    Integer getCount();

    //查询所有的用户信息
    List<User> getAllUser();

    //查询所有用户信息为Map集合
//    List<Map<String, Object>> getAllUserMap();
//    或者，以唯一 id作为键加注解
    @MapKey("id")
    Map<String, Object> getAllUserMap();


}
