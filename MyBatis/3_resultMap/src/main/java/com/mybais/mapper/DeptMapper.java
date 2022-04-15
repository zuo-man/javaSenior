package com.mybais.mapper;

import com.mybais.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分布查询：查询员工以及员工所对应的部门信息
     *      第二步：通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStep_TWO(@Param("did") Integer did);


    //获取部门以及部门中所有的员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);


    /**
     * 通过分布查询查询部门以及部门中所有的员工信息
     *      第一步：查询部门信息
     */
    Dept getDeptAndEmpByStep_ONE(@Param("did") Integer did);

}
