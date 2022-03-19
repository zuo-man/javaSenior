package com.java;

/**
 *  使用同步方法解决实现Runnable接口的线程安全问题
 *
 *  关于同步方法的总结：
 *  1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 *  2.非静态的同步方法，同步监视器是：当前类的本身
 *
 * @create 2021-10-08 15:53
 */
class Window2 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
              show();
            }
        }


    private synchronized void show() {//同步监视器：this
    //symchronized(this)
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.start();
        w2.start();
        w3.start();
    }
}