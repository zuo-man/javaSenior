package com.java1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * @create 2021-11-04 20:33
 */
public class java9Test {
    //java9新特性，钻石操作符的升级
    @Test
    public void test1(){
        Comparable<Object> com = new Comparable<Object>() {//Object可以省略
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        //jdk7:类型推断
        ArrayList<String> a1 = new ArrayList<>();
    }
    //java9特性：try操作升级
    public static void main(String[] args) {
        //之前操作
//        InputStreamReader I1 = null;
//        try {
//            I1 = new InputStreamReader(System.in);
//            char[] c = new char[20];
//            int len;
//            if((len = I1.read(c)) != -1) {//-1表示如果达到文件末尾，返回-1
//                String str = new String(c, 0, len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(I1 != null){
//                try {
//                    I1.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        //8操作:
        //括号中，可以实现资源的自动关闭
//        try (InputStreamReader I1 = new InputStreamReader(System.in)){
//            char[] c = new char[20];
//            int len;
//            if((len = I1.read(c)) != -1) {//-1表示如果达到文件末尾，返回-1
//                String str = new String(c, 0, len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //java9操作
        //资源自动关闭操作：需要自动关闭的资源实例化可以放在try的一对小括号外
        //此时的资源属性是常量，声明为final，不可更改
        InputStreamReader I1 = new InputStreamReader(System.in);
        try (I1){
            char[] c = new char[20];
            int len;
            if((len = I1.read(c)) != -1) {//-1表示如果达到文件末尾，返回-1
                String str = new String(c, 0, len);
                System.out.println(str);

            }

            //reader = null//reader不可更改
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
