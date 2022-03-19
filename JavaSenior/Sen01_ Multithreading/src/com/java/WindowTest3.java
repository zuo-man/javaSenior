package com.java;

/**
 *  使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 * @create 2021-10-09 16:57
 */
class Window3 extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show(){//同步监视器：Windows3.class
//  private synchronized void show(){//同步监视器：w1,w2,w3 .错误的
        if (ticket > 0) {
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.start();
        w2.start();
        w3.start();
    }
}
