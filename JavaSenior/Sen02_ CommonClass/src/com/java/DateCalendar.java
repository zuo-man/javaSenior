package com.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar日历类（抽象类）的使用
 *
 * @create 2021-10-13 18:42
 */
public class DateCalendar {
    @Test
    public void test1() {
        //1.实例化
        //方式一：创建子类（GREgorian Calendar）的对象
        //方式二：调用静态方法getInstance()
        Calendar C1 = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = C1.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        System.out.println(days);
        System.out.println(C1.get(Calendar.DAY_OF_YEAR));//获取今天是这年的第几天

        //set()
        C1.set(Calendar.DAY_OF_MONTH,22);//修改今天是这个月的第几天
        days = C1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        C1.add(Calendar.DAY_OF_MONTH,3);//增加今天是这个月的第几天
        days = C1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 ---> Date
        Date date = C1.getTime();
        System.out.println(date);

        //setTime():Date --->日历类
        Date date1 = new Date();
        C1.setTime(date1);
        days = C1.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
