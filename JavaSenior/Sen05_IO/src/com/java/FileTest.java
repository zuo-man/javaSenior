package com.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、文件大小等方法，
 *       并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 *
 *
 * @create 2021-10-22 20:07
 */
public class FileTest {
    /*
    1.创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.相对路径：相较于某个路径下，指明的路径
      绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
       windows:\\
       unix:/
     */
    @Test
    public void test1(){
        //构造器1
        File F1 = new File("hello.txt");//相对于当前module
        File F2 = new File("D:\\javaSenior\\JavaSenior\\Sen05\\he.txt");

        System.out.println(F1);
        System.out.println(F2);

        //构造器2
        File F3 = new File("D:\\javaSenior\\JavaSenior","Sen05");
        System.out.println(F3);

        //构造器3:
        File F4 = new File(F3,"hi.txt");
        System.out.println(F4);
    }

    /*
    常用方法:
    public String getAbsolutePath()：获取绝对路径
    public String getPath()：获取路径
    public String getName()：获取名称
    public String getParent()：获取上层文件目录路径。若无，返回null
    public Long Length():获取文件长度(即：字节数)。不能获取目录的长度。
    public longLastModified（）：获取最后一次的修改时间，毫秒值
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    /*如下的两个方法适用于文件目录：
    public String[] List()：获取指定目录下的所有文件或者文件目录的名称数组
    public Filel] ListFiles()：获取指定目录下的所有文件或者文件目录的File数组
    */
    @Test
    public void test3(){
        File F1 = new File("D:\\javaSenior\\JavaSenior");//文件不存在报错

        String[] l1 = F1.list();
        for(String s : l1){
            System.out.println(s);
        }

        System.out.println();

        File[] F2 = F1.listFiles();
        for(File s : F2){
            System.out.println(s);//输出的仍然是字符串
        }
    }
    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：F1.renameTo(F2)为例：
         要想返回true，需要F1在硬盘中是存在的，且F2不能在硬盘中存在
     */
    @Test
    public void test4(){
        File F1 = new File("hello.txt");
        File F2 = new File("D:\\javaSenior\\JavaSenior\\Sen05\\hi.txt");

        boolean R = F1.renameTo(F2);//将F1文件转移到F2路径下
        System.out.println(R);
    }
    /*
    public boolean isDirectory()：判断是否是文件目录
    public boolean isFile()：判断是否是文件
    public boolean exists()：判断是否存在
    public boolean canRead()：判断是否可读
    public boolean canWrite()：判断是否可写
    public boolean isHidden()：判断是否隐藏
    */
    @Test
    public void test5() {
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
    /*
    创建硬盘中对应的文件或文件目录
        public boolean createNewFile()：创建文件。若文件存在，则不创建，返回false
        public boolean mkdir()：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录也存在，则不创建
        public boolean mkdirs()：创建文件目录。如果上层文件目录不存在，一并创建
    删除磁盘中的文件或文件目录
        public boolean delete()：删除文件或者文件夹
    删除注意事项：
        Java中的删除不走回收站。
*/
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if (!file1.exists()){//如果文件不存在
            file1.createNewFile();
            System.out.println("创建成功");
        }else {//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test7(){
    //文件目录的创建
        File file1 = new File("D:\\javaSenior\\JavaSenior\\Sen05\\io1\\io3");
        boolean mkdir =file1.mkdir();
        if(mkdir) {
            System.out.println("创建成功1");
        }
        File file2 = new File("D:\\javaSenior\\JavaSenior\\Sen05\\io1\\io4");
        boolean mkdir1 = file2.mkdirs();
        if(mkdir1) {
            System.out.println("创建成功2");
        }
    }
}
