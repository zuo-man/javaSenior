package com.java1;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：可以存储和读取基本数据类型数据或对象的处理流，可以把Java中的对象写入到
 *        数据源中，也能把对象从数据源中还原出来
 *
 *
 *
 * @create 2021-10-25 20:41
 */
public class ObjectInOutStream {
    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test1() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("object.txt"));

        os.writeObject(new String("伊克丝"));
        os.flush();//刷新

        os.writeObject(new Person("唯",19));
        os.flush();

        os.close();
    }
    //反序列化：将磁盘文件中的对象数据还原成内存中的一个java对象
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("object.txt"));

        System.out.println(oi.readObject());

        Person p = (Person)oi.readObject();
        System.out.println(p);


        oi.close();

    }
}
