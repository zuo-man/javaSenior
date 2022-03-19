package com.exer;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 三天打鱼两天晒网   1990-01-01 到输入的时间
 *                  渔夫在打🐟，还是在晒网？
 *
 * @create 2021-10-12 20:48
 */
public class Flash {
    @Test
    public void test1() throws ParseException {
        //获取1990-01-01的时间戳
        String start = "1990-01-01";
        SimpleDateFormat S1 = new SimpleDateFormat("yyyy-MM-dd");

//        Date timeStart = S1.parse(start);
//        System.out.println(timeStart.getTime());
        long timeStart = (S1.parse(start)).getTime();//将字符串解析为 util 下的 Date
                                                     //631123200000

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年月日：");
        String time = scan.next();//获取输入的时间

        long timeend = (S1.parse(time)).getTime();//输入的时间戳

        long T1 = (timeend - timeStart)/86400000;//一天的毫秒数

        if((T1%5) == (1&2&3)){
            System.out.println("打🐟");
        }else{
            System.out.println("晒网");
        }

    }
}
