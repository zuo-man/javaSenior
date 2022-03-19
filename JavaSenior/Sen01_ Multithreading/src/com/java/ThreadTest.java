package com.java;

/**
 * 多线程的创建：方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run（） -->将此线程执行的操作声明在run()方法中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start（）
 *
 * 例:遍历100以内所有的偶数
 *
 *
 * @create 2021-10-06 17:12
 */

class MyThread extends Thread{
    //重写Thread类的run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);//线程名
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        //调用start方法
        //①启动当前线程 ②调用当前线程的run方法
        t1.start();//分线程正在运行

        //在启用一个线程。需要重新创建一个线程对象
//        MyThread t2 = new MyThread();
//        t2.start();

        //如下操作仍然是在main线程中执行
        System.out.println(Thread.currentThread().getName() + ":" + "hellow");//主线程正在运行
    }
}
