package com.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流二：转换流
 * 1.转换流：属于字符流
 *  InputStreamReader: 将一个字节的输入流转换为字符的输入流
 *  OutputStreamWriter: 将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节 ---> 字符串
 *   编码：字符串 ---> 字节
 *
 * 4.字符集
 *
 * @create 2021-10-25 16:25
 */
public class InputSteamReaderTest {
    /*
    处理异常，仍然用try-catch
    InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("hello.txt");
        InputStreamReader i = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明的字符集，具体使用哪个字符集，取决于文件hello.txt保存时使用的字符集
//        InputStreamReader i = new InputStreamReader(fis,"UTF-8");

        char[] arr = new char[5];
        int len;
        while((len = i.read(arr)) != -1){
            String str = new String(arr,0,len);
            System.out.print(str);
        }

        i.close();
    }

    /*
    综合使用IonputStreamReader 和 OutputStreamWriter
     */
    @Test
    public void test2() throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("hello.txt")),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("hello1.txt")),"gbk");

        char[] arr = new char[5];
        int len;
        while ((len = isr.read(arr)) != -1){
            osw.write(arr,0,len);
        }

        isr.close();
        osw.close();
    }
}
