package com.java;

import org.junit.Test;

import java.util.Date;

/**
 * @create 2021-10-11 22:21
 */
public class DateTime {
    //System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970-1-1 00.00 之间以毫秒为单位的时间差
        //时间戳
        System.out.println(time);
    }

    /*
    java.util.Date类
            /---java.sql.Date类
    1.两个构造器的使用

    2.两个方法的使用
        >toString():显示当前日期，时间
        >getTime():获取当前Date对象对应时间戳
     */
    @Test
    public void test2(){
        //构造器一：Date():创建与一个对应当前时间的Date 对象
        Date d1 = new Date();
        System.out.println(d1.toString());//Mon Oct 11 22:28:22 CST 2021

        System.out.println(d1.getTime());//1633962604363

        //构造器二：创建指定毫秒数的Date对象
        Date d2 = new Date(1666666666666L);
        System.out.println(d2.toString());

        //创建java.sql.Date对象
        java.sql.Date d3 = new java.sql.Date(33333333333L);
        System.out.println(d3);//1971-01-22

    }

    /*
    java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test3(){
        //如何将java.util.Date对象转换为java.sql.Date对象（util父类，sql子类）
        //情况一：
        Date d1 = new java.sql.Date(44444444444L);//子类赋给父类
        java.sql.Date d2 = (java.sql.Date) d1;//将util类d1强转成sql类
        System.out.println(d2);

        //情况二：
        Date d3 = new Date();//util类d3
        java.sql.Date d4 = new java.sql.Date(d3.getTime());//d3getTime():获取当前Date对象对应时间戳,转换为sql类的d4
        System.out.println(d4);
    }
}
