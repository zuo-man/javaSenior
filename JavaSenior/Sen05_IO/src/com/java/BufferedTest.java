package com.java;

import org.junit.Test;

import java.io.*;
/**
 * 处理流之一：缓冲流使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流：就是“套接”在已有的流的基础上
 *
 * @create 2021-10-24 13:07
 */
public class BufferedTest {
    @Test
    public void test1() throws IOException {//线程的关系，尽量不要抛异常，用try-catch
        //1.造文件
        File F1 = new File("下载.jpg");
        File copyF1 = new File("下载1.jpg");

        //2.造流
        //2.1 造节点流
        FileInputStream fis = new FileInputStream(F1);
        FileOutputStream fos = new FileOutputStream(copyF1);
        //2.2 造缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //3.复制的细节：读取、写入
        byte[] buffer = new byte[10];
        int len;
        while ((len = bis.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }

        //4.资源关闭
        //要求：先关闭外层的流，再关闭内层的流
        bos.close();
        bis.close();
        //说明：关闭外层流的同时，内层流也会自动关闭。可以省略
//        fos.close();
//        fis.close();
    }
    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter() throws IOException {//线程的关系，尽量不要抛异常，用try-catch

        BufferedReader br = new BufferedReader(new FileReader(new File("hello.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));

        //读写操作
        //方式一：
//        char[] cbuf = new char[1024];
//        int len;
//        while((len = br.read(cbuf)) != -1){
//            bw.write(cbuf,0,len);
//        }
        //方式二：使用String
        String data;
        while((data = br.readLine()) != null){//按行读取文件内容
            //方法一：
//            bw.write(data + "\n");//data中不包含换行符
            //方法二：
            bw.write(data);//data中不包含换行符
            bw.newLine();//提供换行的操作
        }


        //关闭资源
        br.close();
        bw.close();
    }
}
