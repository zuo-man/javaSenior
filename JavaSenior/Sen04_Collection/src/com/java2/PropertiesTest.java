package com.java2;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Properties
 *      常用来处理配置文件。key和value都是String类型
 *
 * @create 2021-10-21 20:50
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {//try快捷键：ctrl + alt + t

        Properties P1 = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        P1.load(fis);//加载流对应的文件

        String n= P1.getProperty("name");
        String p = P1.getProperty("password");

        System.out.println(n + p);

        fis.close();
    }
}
