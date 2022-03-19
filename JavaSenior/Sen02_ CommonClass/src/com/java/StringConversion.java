package com.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * String转换
 *
 * @create 2021-10-11 20:13
 */
public class StringConversion {
    /*
    String与基本数据类型、包装类之间的转换

    String ---> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 --->String：调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
        //int sum = (int)str1;//错误的，字父类关系才能用
        int num = Integer.parseInt(str1);//String转int类型

        String str2 = String.valueOf(num);//int转String
    }
    /*
    String 与 char[]之间的转化

    String ---> char[]:调用String的toCharArray()
    char[] ---> String:调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";

        char[] C1 = str1.toCharArray();
        for(int i = 0; i < C1.length; i++){
            System.out.println(C1[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }
    /*
    String 与byte[]之间的转换

    String ---> byte[]:调用String的getBytes()
    byte[] ---> String:调用String的构造器
     */
    @Test
    public void test3(){
        String str1 = "abc啊";
        byte[] b1 = str1.getBytes();//使用默认字符集，进行转换
        System.out.println(Arrays.toString(b1));

        String str2 = new String(b1);
        System.out.println(str2);
    }
}
