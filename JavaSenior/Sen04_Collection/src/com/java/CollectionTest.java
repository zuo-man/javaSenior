package com.java;

import org.junit.Test;

import java.util.*;
/**
 * 一：集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称java容器
 *   说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt .jpg .avi 数据库）
 *
 * 2.数组：
 *      >一旦初始化以后，其长度就确定了
 *      >数据一旦定义完成，其元素的类型也就确定了，只能操作指定类型的数据
 *       如：String[] arr;int[] arr1;Object[] arr2
 *
 * 二：集合框架
 *      /---Collection接口：单列集合，用来存储一个一个的对象
 *          /---List接口：存储有序的、可重复的数据  --->"动态"数组
 *              /---ArrayList  LinkedList  Vector
 *
 *          /---Set接口：存储无序的、不可重复的数据  --->高中的"集合"
 *              /---HashSet  LinkedHashSet  TreeSet
 *
 *          /---Map接口：双列集合，用来存储一对(key - value)一对的数据  --->函数：y = f(x)  value = key
 *              /---HashMap  LinkedHashMap  TreeMap  Hashtable  Properties
 *
 *
 * @create 2021-10-17 19:53
 */
public class CollectionTest{
    @Test
    public void test1(){
        Collection C1 = new ArrayList();//接口没有构造器，不能被实例   new的是子类ArrayList类的对象，由父类接口Collection引用，多态性

        //add(Object e)；将元素e添加到集合coll中
        C1.add("AA");
        C1.add(123);//自动装箱
        C1.add(new Date());

        //size()：获取添加的元素的个数
        System.out.println(C1.size());//3

        //addAll(Collection C2):将C2集合中的元素添加到当前的集合中
        Collection C2 = new ArrayList();
        C2.add("CC");
        C1.addAll(C2);

        System.out.println(C1.size());//4
        System.out.println(C1);

        //clear():清空集合元素
        C1.clear();
 
        //isEmpty():判断当前集合是否为空
        System.out.println(C1.isEmpty());
    }



    


    //练习：在List内去除重复数字值，要求尽量简单
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }
}
