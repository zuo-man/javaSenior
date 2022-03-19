package com.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 *  抽象基类                 节点流（或文件流）                                缓冲流（处理流的一种）
 *  InputStream             FileInputStream  (read(byte[] data))             BufferedInputStream    (read(byte[] data))
 *  OutputStream            FileOutputStream (write(byte[] data,0,len)       BufferedOutputStream   (write(byte[] data,0,len)
 *  Reader                  FileReader       (read(char[] data))             BufferedReader         (read(char[] data) / readLine())
 *  Writer                  FileWriter       (write(char[] data,0,len)       BufferedWriter         (write(char[] data,0,len)
 *
 * @create 2021-10-23 14:00
 */
public class FileReaderWriterTest {
    /*
    将hello.txt文件内容读入从程序中，并输出到控制台

    说明；
    1.read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
    2.异常的处理：为了保证流支援一定执行关闭操作，需要使用try-catch-finally处理
    3.读入的文件需要存在，否则报异常
     */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File F1 = new File("hello.txt");//相对路径：相较于当前module
            //如果是main，则是相较于当前工程下
            //2.提供具体的流
            fr = new FileReader(F1);

            //3.数据的读入
            //read():返回读入的第一个字符，如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }
            //方式二：语法上针对于方式一的修改
            int data;
            while((data = fr.read()) != -1){
                System.out.println((char)data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作的升级：使用read的重载方法
    @Test
    public void ftestFileReader1(){
        FileReader fr = null;
        try {
            //1.File类的实例化
            File F1 = new File("hello.txt");

            //2.fileReader流的实例化
            fr = new FileReader(F1);

            //3.读入操作
            //read(char[] C1):返回每次读入C1数组中的字符个数，如果达到文件末尾，返回-1
            char[] C1 = new char[5];
            int len;
            while((len = fr.read(C1)) != -1){
                //错误的写法
//                for(int i = 0 ;i < C1.length;i++){
//                    System.out.print(C1[i]);
//                }
                //正确的：
//                for(int i = 0 ;i < len;i++){
//                    System.out.print(C1[i]);
//                }
                //方式二：
                String str = new String(C1,0,len);//取C1中长度 0到len 的数据
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    //4.资源关闭
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    从内存中写出数据到硬盘的文件中

    说明：
    1.输出操作，对应的File可以不存在，不会报异常
    2
        File对应的硬盘文件不存在，则在输出的过程中，会自动创建此文件
        File对应的硬盘文件存在：
                流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件覆盖
                流使用的构造器是: FileWriter(file,ture)：对原有文件添加
     */
    @Test
    public void testFileWriter() throws IOException {//线程的关系，尽量不要抛异常，用try-catch
        //1.提供File类的对象，指明写出到的文件
        File file = new File("hello.txt");

        //2.提供FileWriter对象，用于数据的写出
        FileWriter fw = new FileWriter(file,true);//true：对原有文件内容添加
                                                         //false：对原有文件内容覆盖

        //3.写出的操作
        fw.write("I need qian");

        //4.流支援的关闭
        fw.close();
    }
    @Test
    public void testFileReaderFileWriter(){//线程的关系，尽量不要抛异常，用try-catch
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            //不能使用字符流来处理图片等字节数据
            File F1= new File("hello.txt");
            File copyF1 = new File("hello2.txt");

            //2.创建输入流和输出流的对象
            fr = new FileReader(F1);
            fw = new FileWriter(copyF1);

            //3.数据的读入和写出操作
            char[] copy = new char[5];
            int len; //记录每次读入到copy数组中的字符的个数
            while((len = fr.read(copy)) != -1){
                //每次写出len个字符
                fw.write(copy,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fr !=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fw !=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
