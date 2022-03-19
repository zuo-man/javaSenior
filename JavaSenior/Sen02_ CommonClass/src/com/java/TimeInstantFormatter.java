package com.java;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @create 2021-10-13 19:49
 */
public class TimeInstantFormatter {
    /*
    Instant的使用
     */
    @Test
    public void test1(){
        //获取本初子午线时间
        Instant I1 = Instant.now();
        System.out.println(I1);

        //添加时间偏移量
        OffsetDateTime O1 = I1.atOffset(ZoneOffset.ofHours(8));//偏移量加8个小时，得到当地时间
        System.out.println(O1);

        //toEpochMilli获取1970-1-1 0分0秒 开始的毫秒数
        System.out.println(I1.toEpochMilli());

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 与 Date(Long millis)相似
        Instant I2 = Instant.ofEpochMilli(14444444444L);
        System.out.println(I2);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test2(){
        //方式一：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter F1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String S1 = F1.format(LocalDateTime.now());
        System.out.println(S1);

        //解析
        TemporalAccessor A1 = F1.parse("2020-02-15 03:23:34");
        System.out.println(A1);






        System.out.println("**********");
        //不常用
        //方式二：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIM
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2019-02-18715:42:18.797
        //解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

        //方式三：本地化相关的格式。如：ofLocalizedDateTime(FolmatStyle.LONG)
        //FormatStyle.LONG                     FormatStyle.MEDIUM      FormatStyle.SHORT:适用于LocalDateTime
        //2021年10月13日 下午08时23分28秒        2021-10-13 20:26:50    21-10-13 下午8:27
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);
    }
}
