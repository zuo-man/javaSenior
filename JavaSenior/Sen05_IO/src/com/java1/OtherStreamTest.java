package com.java1;

import org.junit.Test;
import java.io.*;

/**
 * 1.输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @create 2021-10-25 19:32
 */
public class OtherStreamTest {
    /*
    1.标准的输入、输出流
    System.in:标准的输入流，默认从键盘输入
    System.out:标准的输出流，默认从控制台输出
    2.
    System类的SetIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出流


    练习：
    从键盘输入字符串，转换成大写输出
    e和exit退出程序

    方法一:使用Scanner实现，调用next()返回一个字符串
    方法二：使用System.in实现。system.in ---> 转换流 --->BufferedReader的readLine()
     */
    @Test
    public void test1() throws IOException {//try-catch

        InputStreamReader i = new InputStreamReader(System.in);//转换流
        BufferedReader br = new BufferedReader(i);//缓冲流

        while (true){
            System.out.println("请输入字符串：");
            String data = br.readLine();//读一行数据
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {//相当于data.equalsIgnoreCase("e")
                System.out.println("程序结束");
                break;
            }

            String up = data.toUpperCase();//转换为大写
            System.out.println(up);
        }
        br.close();
    }
    /*
    打印流： PrintStream 和 PrintWriter
     */
    @Test
    public void test2() throws IOException {

        //让文件打印到相应目录下，不在控制台
        FileOutputStream fos = new FileOutputStream("D:\\javaSenior\\JavaSenior\\Sen05\\hello1.txt");
        //创建打印输出流，设置为自动刷新模式（写入换行符或字节 '\n' 时都会刷新输出缓冲区）
        PrintStream p = new PrintStream(fos,true);
        if(p != null){// 把标准输出流（控制台输出）改成文件
            System.setOut(p);
        }

        for(int i = 0;i <= 255; i++){
            System.out.print((char)i);
            if(i % 50 == 0) {//每50个数据一行
                System.out.println();//换行
            }
        }

        fos.close();
        p.close();
    }
    /*
    数据流：DataInputStream 和 DataOutputStream
    作用：用于读取或写出基本数据类型的变量或字符串

    练习：将内存中的字符串、基本数据类型的变量写出到文件中
     */
    @Test
    public void test3() throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("千姬");
        dos.flush();//刷新
        dos.writeInt(17);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }
    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    //读取数据要与写入顺序一致，否则报异常
    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println(name + age + isMale);

        dis.close();
    }
}

