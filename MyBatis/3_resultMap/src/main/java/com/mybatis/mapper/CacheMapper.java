package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);
}
