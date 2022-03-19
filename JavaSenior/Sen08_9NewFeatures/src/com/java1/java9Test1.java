package com.java1;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @create 2021-11-05 10:46
 */
public class java9Test1 {
    //9新特性：InputStream新方法：tranferTo()
    @Test
    public void test4(){
        ClassLoader c1 = this.getClass().getClassLoader();//getClassLoader：获取当前类的加载器
        try(InputStream i1 = c1.getResourceAsStream("hello.txt");   //不同流之间分号;隔开
            OutputStream o = new FileOutputStream("src\\hello1.txt")){
            i1.transferTo(o); //把输入流中的所有数据直接自动的复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }

    //8之前创建只读集合
    @Test
    public void test1(){
        List<String> l1 = new ArrayList<>();
        l1.add("无暇");
        l1.add("小真");
        l1.add("格兰尼");
        //umodifiableList:返回的l1是一个只读集合
        l1 = Collections.unmodifiableList(l1);
//        l1.add("千姬");//运行抛异常

        System.out.println(l1);
    }
    @Test
    public void test2(){
        //此时得到的集合list也是一个只读集合
        List<Integer> list = Arrays.asList(1,2,3);
        //添加报异常
        list.add(5);
    }
    //java9特性：集合工厂方法：创建只读集合
    //of
    @Test
    public void test3(){
        List<String> l1 = List.of("小优","千姬");
//        l1.add("无暇");

        System.out.println(l1);
    }

}
