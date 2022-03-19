package com.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
 *
 * @create 2021-10-20 16:03
 */
public class CollectionTest1 {
    @Test
    public void test1(){
        Collection C1 = new ArrayList();
        C1.add(123);
        C1.add(new String("小优"));
        C1.add(false);
        C1.add(new Person("无暇",18));//自定义类

        //1.contains（Object obj）：判断当前集合是否包含obj
        //判断时会调用obj对象所在类的equals()
        boolean con = C1.contains(123);
        System.out.println(con);

        System.out.println(C1.contains(new String("小优")));
        System.out.println(C1.contains(new Person("无暇",18)));//没有重写equals方法false，重写后，返回true

        System.out.println("******");

        //2.containsAll(Collection C1):判断形参C2中所有元素是否都存在于当前集合C1中
        Collection C2 = Arrays.asList(123,234);
        System.out.println(C2.containsAll(C1));

        System.out.println("******");

        //3.remove(Object obj):从当前集合中移除obj元素
        C1.remove(123);//先查找，同时也会调用equals方法，再移除
        System.out.println(C1);

        //4.removeAll(Collection C1):差集：从当前集合中移除C1中所有的元素
        Collection C3 = Arrays.asList(new String("小优"),false);
        C1.removeAll(C3);
        System.out.println(C1);
    }

    @Test
    public void test2(){
        Collection C1 = new ArrayList();
        C1.add(123);
        C1.add(new String("小优"));

        //5.retainAll(Collection C1):交集：获取当前集合和C1集合的交集，并返回给当前集合
        Collection con = Arrays.asList(new String("小优"),false);
        C1.retainAll(con);
        System.out.println(C1);

        System.out.println("******");

        Collection C2 = new ArrayList();
        C2.add(new String("小优"));
        C2.add(123);

        //6.equals(Object obj):判断当前集合形参
        System.out.println(C1.equals(C2));//是有序比较，打乱之后false
    }

    @Test
    public void test3(){
        Collection C1 = new ArrayList();
        C1.add(123);
        C1.add(345);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(C1.hashCode());

        //8.集合 --->数组：toArray()
        Object[] arr = C1.toArray();
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }

        //数组 --->集合:调用Array类的静态方法asList()
        List<String> l1 = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(l1);

        List arr1 = Arrays.asList(new int[]{123,345});//识别的是new的整个对象一个元素
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123,345});//包装类，识别的是对象里面
        System.out.println(arr2.size());//2

        System.out.println("******");

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
