package com.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *     /---Collection接口：单列集合，用来存储一个一个的对象
 *         /---List接口：存储有序的、可重复的数据  --->"动态"数组，替换原有的数组
 *
 *            /---ArrayList：作为List接口的主要实现类：线程不安全的，效率高：底层使用Object[]数组存储
 *                           建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)//int 存放数据数组的长度 ,来避免数组扩容
 *
 *            /---LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高：底层使用双向链表存储
 *
 *            /---Vector：作为List接口的古老实现类：线程安全的，效率低：底层使用Object[]数组存储
 *
 * @create 2021-10-20 19:19
 */
public class ListTest {
    //List常用方法
    /*
    void add(int index, Object ele)：在index位置插入ele元素
    boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加
    Object get(int index):获取指定index位置的元素
    int indexof(Object obj)：返回obj在集合中首次出现的位置，如果不存在，返回-1
    int LastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    Object remove(int index):移除指定index位置的元素，并返回此元素
    Object set(int index, Object ele)：设置指定index位置的元素为ele
    List sublist(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置左闭右开的子集合

    总结：
    增：add(Object obj)
    删：remove(int index) / remove(Object obj)
    改：set(int index, Object ele)
    查：get(int index)
    插：add(int index, Object ele)
    长度：size()
    遍历：①Iterator迭代器方式
         ②增强for循环
     */
    @Test
    public void test3() {
        ArrayList C1 = new ArrayList();
        C1.add(123);
        C1.add(345);

        C1.add(1,"BB");/*在index位置插入ele元素*/
        System.out.println(C1);

        List l1 = Arrays.asList(22);
        C1.addAll(l1);/*从index位置开始将eles中的所有元素添加*/
        System.out.println(C1.size());//4

        System.out.println("****");

        int i1 = C1.indexOf(345);
        System.out.println(i1);/*返回obj在集合中首次出现的位置，如果不存在，返回-1*/
    }
    @Test
    public void test2(){
        ArrayList C1 = new ArrayList();
        C1.add(123);
        C1.add(345);
        C1.add(3);
        C1.add(new String("小优"));

        Object o = C1.remove(1);/*移除索引：移除指定index位置的元素，并返回此元素*/
        System.out.println(o);
        System.out.println(C1);

        C1.remove(new Integer(3));/*移除对象：移除名称为3的对象

        System.out.println("*******");

        //修改
        C1.set(0,"AA");/*设置指定index位置的元素为ele*/
        System.out.println(C1);

        System.out.println("*******");

        List l1 = C1.subList(1,2);/*返回从fromIndex到toIndex位置左闭右开的子集合*/
        System.out.println(l1);
    }
}
