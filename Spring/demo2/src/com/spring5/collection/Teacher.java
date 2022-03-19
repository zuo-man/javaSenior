package com.spring5.collection;

/**
 * @create 2022-02-26 14:35
 */
public class Teacher {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}
