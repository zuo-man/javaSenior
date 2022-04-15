package com.boot.service;

import com.boot.bean.Dept;

public interface DeptService {

    public Dept getDeptByid(Integer did);

    public void saveDept(Dept dept);
}
