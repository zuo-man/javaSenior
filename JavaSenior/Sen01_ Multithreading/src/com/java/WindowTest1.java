package com.java;

/**
 * 例：创建三个窗口买票，总票数为100张,使用实现Runnable接口的方式
 *
 * 线程安全问题：当线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 *
 *  方式一：同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码
 *  }
 *
 *  说明：1.操作共享数据的代码，即为需要被同步的代码
 *       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *       3.同步监视器（锁），任何一个类的对象，都可以充当锁
 *          要求：多个线程必须要公用同一把锁
 *
 *
 *  局限性：操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程过程，效率低
 *
 *
 * @create 2021-10-07 15:23
 */

class Window1 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//此时this：唯一的window1对象w  //方式二：synchronized(obj)

                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.start();
        w2.start();
        w3.start();
    }
}