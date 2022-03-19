package com.java1;

import com.team.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-10-31 15:09
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"千姬",19,3999));
        list.add(new Employee(1002,"唯",21,2000));
        list.add(new Employee(1003,"无暇",18,6000));
        list.add(new Employee(1004,"无忧",22,100));


        return list;
    }
}
