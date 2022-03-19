package com.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @create 2021-10-29 20:45
 */
public class ClassLoaderTest {
    //
    @Test
    public void test1() throws Exception {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        FileInputStream fis1 = new FileInputStream("src\\jdbc.properties");//如果在src下。
//        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();//自定义类，使用系统类加载器进行加载
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("uesr=" + user  + ",password="  + password);
    }
}
