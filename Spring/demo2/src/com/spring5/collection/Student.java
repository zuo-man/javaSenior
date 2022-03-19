package com.spring5.collection;

import java.util.*;

/**
 * @create 2022-02-26 13:56
 */
public class Student {
    //1.数组类型属性
    private String[] courses; //学生学的各种课程

    //2.list集合类型属性
    private List<String> list;

    //3.map集合类型属性
    private Map<String, String> map;

    //4.set集合类型属性
    private Set<String> set;

    //学生的不同老师，是对象
    private List<Teacher> teaList;

    public void setTeaList(List<Teacher> teaList) {
        this.teaList = teaList;
    }
    public void setCourses(String[] courses) {
        this.courses = courses;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void test(){
        System.out.println(Arrays.toString(courses)); //作为字符串输出
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(teaList);
    }
}

