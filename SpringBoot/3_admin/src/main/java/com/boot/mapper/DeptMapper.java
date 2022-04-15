package com.boot.mapper;

import com.boot.bean.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Repository ：将类或接口标识为持久化组件 ，注入Mapper就没问题了，也可以不加
 */

@Repository
//@Mapper
public interface DeptMapper {

    //使用注解配置
    @Select("select * from t_dept where did = #{did}")
    public Dept getDept(Integer did);


    //使用xml配置： DeptMapper.xml

    //使用注解配置
    @Insert("insert into t_dept(`did`, `dept_name`) values(#{did}, #{deptName})")
    @Options(useGeneratedKeys = true, keyProperty = "did")
    public Integer insert(Dept dept);

}
