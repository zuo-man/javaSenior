package com.spring5.aut;

/**
 * @create 2022-02-26 17:24
 */
//不同的部门
public class Department {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
