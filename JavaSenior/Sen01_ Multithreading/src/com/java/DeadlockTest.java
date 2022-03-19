package com.java;

/**
 *  演示死锁的问题
 *
 * @create 2021-10-09 18:51
 */
public class DeadlockTest  {
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            public void run(){
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();


        new Thread(new Runnable() {
            public void run(){
                synchronized (s2){
                    s1.append("a");
                    s2.append("1");

                    synchronized (s1){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

    }

}
