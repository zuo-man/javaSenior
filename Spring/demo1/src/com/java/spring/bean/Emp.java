package com.java.spring.bean;

/**
 * @create 2022-02-26 13:21
 */

//员工类
public class Emp {
    private String name;
    private String gender;//性别
    private Dept dept; //员工属于某一个部门，使用对象形式表示

    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    //生成dept的get方法
    public Dept getDept() {
        return dept;
    }

    public void add(){
        System.out.println(name + ", " + gender + ", " + dept);
    }
}
