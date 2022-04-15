package com.boot.mapper;

import com.boot.bean.Dept;
import com.boot.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface EmpMapper {


    //使用xml配置 ：DeptMapper.xml
    public Emp getEmp(Integer eid);

}
