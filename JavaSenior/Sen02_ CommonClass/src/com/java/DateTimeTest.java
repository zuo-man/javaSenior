package com.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * 注意：获取月份时：一月是0，二月是 1...十二月是11
 *      获取星期时：周日是1，周一是 2...周六是7
 *
 * @create 2021-10-12 20:07
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     */
    @Test
    public void tese1() throws ParseException {
        //实例化SimpleDateFormat ： 使用默认的构造器
        SimpleDateFormat S1 = new SimpleDateFormat();

        //格式化： 日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String F1 = S1.format(date);//格式化format
        System.out.println(F1);

        //解析：格式化的逆过程： 字符串 ---> 日期
        String str = "22-03-22 下午8:20";//必须遵守格式，否则抛异常
        Date date1 = S1.parse(str);
        System.out.println(date1);


        System.out.println("******按指定方式格式化和解析*******");

        //格式化
        SimpleDateFormat S2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//调用带参构造器
        String F2 = S2.format(date);
        System.out.println(F2);

        //解析
        Date date2 = S2.parse("2222-12-12 08:26:39");//要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）,否则抛异常
        System.out.println(date2);
    }

    /*
    练习一：字符串""转换成java.sql.Date
     */
    @Test
    public void test2() throws ParseException {
        String birth = "2222-12-12";

        SimpleDateFormat S1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = S1.parse(birth);//将字符串解析为 util 下的 Date
        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
}
