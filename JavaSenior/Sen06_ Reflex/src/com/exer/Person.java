package com.exer;

import java.util.Comparator;

/**
 * @create 2021-10-30 10:49
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparator<String>,MyInterface {

    private String name;
    int age;
    public int id;

    public Person(){}
    @MyAnnotation(value = "构造器")
    private Person(String name){
        this.name = name;
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "方法")
    private String show(String nation){
        System.out.println("我的国籍是:" + nation);
        return nation;
    }

    private static void walk(){
        System.out.println("走");
    }

    @Override
    public void info() {
        System.out.println("我是人");
    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
