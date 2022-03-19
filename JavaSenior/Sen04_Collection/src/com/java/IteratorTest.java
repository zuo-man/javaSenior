package com.java;

import org.junit.Test;

import java.util.*;
/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 *
 * 1.内部方法：hasNext() 和 next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 *   默认游标都在集合的第一个元素之前
 * 3.remove()，删除集合中的元素，此方法不同于集合直接调用remove()
 *
 * @create 2021-10-20 17:26
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection C1 = new ArrayList();
        C1.add(123);
        C1.add(new String("小优"));

        Iterator i = C1.iterator();

        //方式一：
//        System.out.println(i.next());
//        System.out.println(i.next());
//        //报异常：NoSuchElementException
//        System.out.println(i.next());

        //方式二：
        while(i.hasNext()){//检查集合中是否有元素，有的话进循环
            System.out.println(i.next());
        }

        //错误方式：
//        while(C1.iterator().hasNext()){
//            System.out.println(C1.iterator().next());
//        }
    }

    @Test
    public void test2(){
        Collection C1 = new ArrayList();
        C1.add(123);
        C1.add(new String("小优"));

        Iterator i = C1.iterator();

        //remove:移除
        while(i.hasNext()){
            Object o = i.next();
            if("小优".equals(o)){
                i.remove();
            }
        }

        //遍历
        i = C1.iterator();//将指针重启
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
