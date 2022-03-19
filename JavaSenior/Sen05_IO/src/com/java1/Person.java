package com.java1;

import java.io.Serializable;

/**
 *  Person需要满足如下条件，方可序列化
 *  1.需要实现接口：Serializable
 *  2.当前类提供一个全局常量：serialVersionUID，随机指定一个值
 *  3.内部所有属性必须是可序列化的（默认情况，基本数据类型可序列化）
 *
 * @create 2021-10-26 16:12
 */

//标识接口，表示当前Person类可序列化
public class Person implements Serializable {

    public static final long serialVersionUID = 32146465465L;//随机写一个值

    private String name;
    private int age;

    public Person() {
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
