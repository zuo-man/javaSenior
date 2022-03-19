package com.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 1.直接继承于java.lang.Object类，实现了DataInput 、 DataOutput接口
 * 2.即可以作为一个输入流，也可以作为一个输出流
 *
 * r:只读
 * rw：读写
 *
 * 3.作为输出流时，写出到的文件不存在时，则在执行过程中自动创建
 *                      文件存在时，则会对原有文件内容进行覆盖（默认从头覆盖）
 *
 * @create 2021-10-26 16:40
 */
public class RandomAccessFileTest {
    @Test
    public void test1() throws IOException {

        RandomAccessFile rin = new RandomAccessFile(new File("下载.jpg"),"r");
        RandomAccessFile rout = new RandomAccessFile(new File("下载1.jpg"),"rw");

        byte[] arr = new byte[100];
        int len;
        while ((len = rin.read(arr)) != -1){
            rout.write(arr,0,len);
        }

        rin.close();
        rin.close();
    }
    //覆盖
    @Test
    public void test2() throws IOException {

        RandomAccessFile rout = new RandomAccessFile("hello.txt","rw");

        rout.seek(3);//将指针调到角标为3的位置，想在最后添加数据时，获取长度调角标
        rout.write("QQQ".getBytes());//覆盖文件

        rout.close();
    }
}
