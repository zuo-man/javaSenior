package com.boot.mapper;

import org.apache.ibatis.annotations.Param;

import com.boot.entities.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User>{

    User getById(@Param("id") Integer id);

}
