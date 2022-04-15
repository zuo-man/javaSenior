package com.boot.service.impl;

import com.boot.bean.Dept;
import com.boot.mapper.DeptMapper;
import com.boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    public Dept getDeptByid(Integer did) {
        return deptMapper.getDept(did);
    }

    public void saveDept(Dept dept) {
        deptMapper.insert(dept);
    }
}
