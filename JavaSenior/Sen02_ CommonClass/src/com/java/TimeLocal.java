package com.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @create 2021-10-13 19:17
 */
public class TimeLocal {
    /*
    LocalDate、lacalTime、LocalDateTime的使用
     */
    @Test
    public void test1(){

        //now():获取当前的日期、时间、日期+时间
        LocalDate D1 = LocalDate.now();//静态方法，直接调用
        LocalTime T1 = LocalTime.now();
        LocalDateTime L1 = LocalDateTime.now();

        System.out.println(D1);
        System.out.println(T1);
        System.out.println(L1);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime L2 = LocalDateTime.of(2222,12,22,12,12,12);
        System.out.println(L2);

        System.out.println("**************");

        //getXxx()：获取相关属性
        System.out.println(L1.getMinute());//获取第几分钟
        System.out.println(L1.getDayOfMonth());//获取今天是这个月是第几天
        System.out.println(L1.getMonthValue());//获取是今年的第几月
                                                //等等

        //lacal类的不可变性
        //withXxx()：设置相关属性
        LocalDateTime L3 = L2.withDayOfMonth(11);
        System.out.println(L2);
        System.out.println(L3);

        LocalDateTime L4 = L2.plusMonths(3);//加三个月,plus加，minus减
        System.out.println(L4);
    }
}
