package com.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全方式三：Lock🔒
 *
 * synchronized 与 lock的异同
 *      相同：二者都可以解决线程安全问题
 *      不同：synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 *           lock需要手动的启动同步Lock()，手动结束同步unLock()
 *
 * @create 2021-10-09 19:16
 */
class Lick1 implements Runnable{
    private int ticket = 10;

    //1.实例化ReentrantLock
    private ReentrantLock lock1 = new ReentrantLock(true);//ture线程按先后顺序执行，false线程随机执行

    @Override
    public void run() {
        while (true){
            try{
                //2.调用Lock方法,🔒
                lock1.lock();

                if(ticket > 0){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3.调用解锁方法，解🔒
                lock1.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Lick1 l1 = new Lick1();

        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(l1);
        Thread t3 = new Thread(l1);

        t1.start();
        t2.start();
        t3.start();
    }
}
