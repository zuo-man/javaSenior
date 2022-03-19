package com.exer;

import org.testng.annotations.Test;

/**
 * @create 2021-10-12 16:55
 */
public class StringDemo {
    /*
    将一个字符串进行反转，将字符串中指定部分进行反转。“abcdefg”反转成“abfedcg”
     */
    //方法一：
    public String F1(String str,int start,int end){
        char[] arr = str.toCharArray();//将String类型转换成char型数组
        for(int x = start,y = end; x < y ; x++, y--){
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);//将char型数组转换成String类型
    }
    @Test
    public void test1(){
        String q = "abcdefg";
        String t1 = F1(q,2,5);

        System.out.println(t1);
    }
    //方法二：使用String拼接
    public String F2(String str,int start, int end){
        String S1 = str.substring(0,start);/*substring 此字符串从beginIndex开始截取到endIndex（不包含）的一个子字符串*/

        for(int i = end; i >= start; i-- ){
            S1 += str.charAt(i);/*charAt 返回某索引处的字符*/
        }

        S1 += str.substring(end + 1);//从end+1开始截取到最后

        return S1;
    }
    @Test
    public void test2(){
        String q = "abcdefgh";
        String t1 = F2(q,2,5);

        System.out.println(t1);
    }
}
