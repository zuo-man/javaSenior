package com.java;

import org.junit.Test;

import java.util.*;

/**
 *
 *  foreach循环：用来遍历集合、数组
 *
 * @create 2021-10-20 19:05
 */
public class ForTest {
    @Test
    public void test1(){
        Collection C1 = new ArrayList();
        C1.add(123);
        C1.add(new String("小茜"));

        //for(集合元素的类型  局部变量 ：集合对象）
        //内部仍然调用了迭代器
        for(Object o : C1){
            System.out.println(o);
        }


        int[] arr = new int[]{1,2,3,4};
        //for(集合元素的类型  局部变量 ：数组对象）
        for(int i : arr){
            System.out.println(i);
        }
    }
}
