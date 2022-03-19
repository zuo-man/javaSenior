package com.java2;

/**
 * 自定义泛型类
 *
 * @create 2021-10-22 13:39
 */
public class Order<T> {
    String name;
    int age;

    //类的内部结构就可以使用类的泛型

    T t;//T类型的t

    public Order(){};
    public Order(String name,int age,T t){
        this.name = name;
        this.age = age;
        this.t = t;
    }

    //如下的三个方法都不是泛型方法
    public T getT(){
        return t;
    }
    public void setT(T t){
        this.t = t;
    }
    @Override
    public String toString() {
        return "Order{" + "name='" + name + '\'' + ", age=" + age + ", t=" + t + '}'; }

}

