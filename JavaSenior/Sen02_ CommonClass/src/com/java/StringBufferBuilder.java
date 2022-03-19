package com.java;

import org.junit.Test;

/**
 * StringBuffer、StringBuilder的使用
 *
 * @create 2021-10-11 21:26
 */
public class StringBufferBuilder {
    /*
    三者底层都使用char[]存储
    String:不可变的字符序列
    StringBuffer：可变的字符序列，线程安全的，效率低
    StringBuilder：可变的字符序列，线程不安全的，效率高

    StringBuffer、StringBuilder如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
    默认情况下，扩容为原来的两倍+2，同时将原有的数组中的元素复制到新的数组中

     */
    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.setCharAt(0,'O');
        System.out.println(s1);
    }

    /*
    StringBuffer、StringBuilder常用方法

    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end):删除指定位置的内容
    StringBuffer replace(int start, int end,String str):把[start,end)位置替换为str 。
    StringBuffer insert(int offset,xxx)：在指定位置插入xxx
    StringBuffer reverse()：把当前字符序列逆转

    总结：
    增：append()
    删：delete(int start,int end)
    改：setCharAt(int n,char ch) / replace(int start, int end, String str)
    查：charAt(int n)
    插：insert(int offset, xxx)

     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);/*append()方法，用于进行字符串拼接*/

        StringBuffer s2 = new StringBuffer("abcd");
        s2.delete(1,3);/*删除指定位置的内容*/
        System.out.println(s2);

        s1.replace(1,3,"!!");
        System.out.println(s1);/*把[start,end)位置替换为str*/

        s2.insert(1,"~~~~");
        System.out.println(s2);/*在指定位置插入xxx*/


        StringBuffer s3 = new StringBuffer("ABCD");
        s3.reverse();
        System.out.println(s3);/*把当前字符序列逆转*/
    }
}
