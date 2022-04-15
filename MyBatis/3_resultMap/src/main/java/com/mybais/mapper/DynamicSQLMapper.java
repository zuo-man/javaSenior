package com.mybais.mapper;

import com.mybais.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    //多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    //测试choose、when、otherwise
    List<Emp> getEmpByChoose(Emp emp);

    //通过数组实现批量删除
    int deleteMoreByArr(@Param("eids") Integer[] eids);

    //通过List集合实现批量添加
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
