package com.java;

/**
 * 例：创建三个窗口买票，总票数为100张，使用继承Thread类的方式
 *
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 说明：在继承Thread类的创建多线程的方式中，慎用this充当同步监视器，可以使用当前类充当同步监视器
 *
 * @create 2021-10-06 20:51
 */
class Window extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {//当前有三个对象，不能用this
        //方式二：synchronized(Window2.class)  //类class中window2是唯一的
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest {
    public static void main(String[] args) {

        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

