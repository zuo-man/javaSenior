package com.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutpuStream使用
 *
 * 结论：
 *  1.对于文本文件，使用字符流处理
 *  2.对于非文本文件，使用字节流处理
 *
 * @create 2021-10-24 12:32
 */
public class FieInputOutput {
    @Test
    public void testFileInputStream() throws IOException {//线程的关系，尽量不要抛异常，用try-catch
        //1.造文件
        File F1 = new File("下载.jpg");
        File copyF1 = new File("下载2.jpg");

        //2.造流
        FileInputStream fis = new FileInputStream(F1);
        FileOutputStream fos = new FileOutputStream(copyF1);

        //3.读数据
        byte[] buffer = new byte[5];
        int len;// 记录每次读取的字节个数
        while((len = fis.read(buffer)) != -1){

            fos.write(buffer,0,len);
        }

        //4.关闭资源
        fis.close();
        fos.close();
    }
}
