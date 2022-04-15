package com.plusX.service;

import com.plusX.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Dell
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-04-15 15:35:05
*/
public interface UserService extends IService<User> {

    List<User> selectAgeUserName(Integer age, String userName);

}
