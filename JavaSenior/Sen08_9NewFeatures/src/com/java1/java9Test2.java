package com.java1;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @create 2021-11-05 11:30
 */
public class java9Test2 {
    //java9新特性：Stream API 加强
    @Test
    public void test1(){
        List<Integer> l1 = Arrays.asList(1,2,3,5,2,1);
        //takeWhile：返回从开头开始的按照指定规则尽量多的元素，一旦有不满足元素，结束并输出
        l1.stream().takeWhile(x -> x < 5).forEach(System.out::println);
        System.out.println("****");
        //dropWhile:与takeWhile相反，返回剩余元素，一旦有不满足元素，结束输出后面全部元素
        l1.stream().dropWhile(x -> x < 5).forEach(System.out::println);
    }
    @Test
    public void test2(){
        //of()参数的多个元素，可以包含null值
        Stream<Integer> s1 = Stream.of(1,2,3,null);
        s1.forEach(System.out::println);
        //of()参数不能存储单个null值，否则抛异常
//        Stream<Object> s2 = Stream.of(null);
//        s1.forEach(System.out::println);

        Integer i = 1;
        i = null;
        //ofNullable():形参变量可以为null值的单个元素，不能存储多个
        Stream<Integer> s2 = Stream.ofNullable(i);
        long c = s2.count();
        System.out.println(c);//没有元素，null
    }
    //新特性：java9新增重载方法
    @Test
    public void test3(){
        //iterate:创建无限流。limit限制输出个数
        Stream.iterate(0,x -> x+1).limit(3).forEach(System.out::println);

        //java9新增重载方法
        Stream.iterate(0,x -> x < 3,x -> x + 1).forEach(System.out::println);
    }
    //新特性：Optional提供了新的方法stream()
    @Test
    public void test4(){
        List<String> l1 = new ArrayList<>();
        l1.add("无暇");
        l1.add("小优");

        Optional<List<String>> o = Optional.ofNullable(l1);
        Stream<List<String>> st = o.stream();
//        long c = st.count();
//        System.out.println(c);//长度为1
        st.flatMap(x -> x.stream()).forEach(System.out::println);//映射元素并输出
    }
}
