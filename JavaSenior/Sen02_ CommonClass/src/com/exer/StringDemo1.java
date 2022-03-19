package com.exer;

import org.testng.annotations.Test;

/**
 * @create 2021-10-12 19:19
 */
public class StringDemo1 {
    /*
    获取两个字符串中最大相同子串，比如：
    str1 = "qwerhelloqwer" ; str2 = "ahelloa" 最大相同子串为hello

     */
    //前提：只有一个最大相同子串
    public String getMaxString(String str1 ,String str2){
        String manxStr = (str1.length() >= str2.length())? str1 : str2;//判断两个字符串，如果str1长度大于str2，
                                                                       //则maxStr=str1，否则maxStr=str2
        String minxStr = (str1.length() <  str2.length())? str1 : str2;
        int length = minxStr.length();//获取短字符串长度

        for(int i = 0; i < length; i++){//大循环，比如ahelloa，从i=0，即从全部开始，找(x=0,y=length-0),
                                        //循环继续，则i-1，找(x=0,y=length-1)

            for (int x = 0, y = length - i; y <= length; x++,y++){
                                        //将两个指针x,y 截取定位到minxStr，循环用方法contains找，
                                        //循环继续，x，y皆后移一位，直到y<=length x,y指针到末尾

                String subStr = minxStr.substring(x,y);/*此字符串从beginIndex开始截取到endIndex（不包含）的一个子字符串*/
                if(manxStr.contains(subStr)){/*当且仅当此字符串包含指定的char值序列时，返回 true*/
                    return subStr;
                }
            }
        }
        return null;
    }
    @Test
    public void test1(){
        String str1 = "qwerhelloqwer";
        String str2 = "ahelloa";

        String q = getMaxString(str1,str2);
        System.out.println(q);
    }
}
