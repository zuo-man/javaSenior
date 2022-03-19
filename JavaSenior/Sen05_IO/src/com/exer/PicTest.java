package com.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @create 2021-10-24 14:04
 */
public class PicTest {
    //图片的加密
    @Test
    public void test1() throws IOException {//线程的关系，尽量不要抛异常，用try-catch
        FileInputStream fis = new FileInputStream("下载.jpg");
        FileOutputStream fos = new FileOutputStream("下载secret.jpg");

        byte[] buffer = new byte[20];
        int len;
        while((len = fis.read(buffer)) != -1){
            //字节数组进行修改，异或加密
            for(int i = 0;i < len; i++){
                buffer[i] = (byte)(buffer[i] ^ 5);//强转异或
            }

            fos.write(buffer);
        }

        fos.close();
        fis.close();
    }
    //图片的解密
    @Test
    public void test2() throws IOException {//线程的关系，尽量不要抛异常，用try-catch
        FileInputStream fis = new FileInputStream("下载secret.jpg");
        FileOutputStream fos = new FileOutputStream("下载解密.jpg");

        byte[] buffer = new byte[20];
        int len;
        while((len = fis.read(buffer)) != -1){
            //字节数组进行修改，异或加密
            for(int i = 0;i < len; i++){
                buffer[i] = (byte)(buffer[i] ^ 5);//强转异或
            }

            fos.write(buffer);
        }

        fos.close();
        fis.close();
    }
}
