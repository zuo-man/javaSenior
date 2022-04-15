package com.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatisplus.pojo.User;

import java.util.Map;

/**
 * IService：service层总接口，        我觉得是对应着BaseMapper的所有方法，就能实现调用
 * <> ：查询哪些数据类型，对User这个进行 CRUD
 */

public interface UserService extends IService<User> {

    //UserMapper的自定义方法
    Map<String, Object> selectMap(Long id);

}
