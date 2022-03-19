package com.java.spring.bean;

/**
 * @create 2022-02-26 13:20
 */

//部门类
public class Dept {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
