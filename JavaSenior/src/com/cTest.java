package com;

import org.junit.Test;

/**
 * @create 2021-11-10 21:15
 */
public class cTest {
    @Test
    public void test1(){
        Thread t = new Thread(){
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }
    static void pong(){
        System.out.print("pong");
    }

    @Test
    public void test2(){
        String str = "123";
        ca(str);
        System.out.println(str);
    }
    public static void ca(String s){
        s = "hello";
    }

}
