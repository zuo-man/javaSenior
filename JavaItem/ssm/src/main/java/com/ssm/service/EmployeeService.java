package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
