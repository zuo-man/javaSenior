package com.exer;

/**
 *  线程通信例：使用两个线程打印1~10，线程1，线程2，交替打印
 *
 * @create 2021-10-09 21:52
 *
 *  wait():线程进入阻塞状态，并释放同步监视器
 *  notify():唤醒被wait的一个线程，如果有多个线程被wait，就会唤醒优先级高的线程
 *  notufyAll():唤醒所有被wait的线程
 *
 *  说明：1.上方三个方法必须使用在同步代码块或同步方法中
 *       2.上方三个方法调用者必须是同步代码块或同步方法中的同步监视器
 *       3.上方三个方法是定义在java.lang.Object类中
 *
 *  sleep()和wait()的异同：
 *  1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 *  2.不同点：1)两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *           2)调用的要求不同：sleep()可以在任何场景下调用。wait()必须使用在同步代码块或同步方法中
 *           3)关于是否释放同步监视器：当两个方法都使用在同步代码块或同步方法中，sleep()不会释放🔒，wait()会释放🔒
 */

class Number implements Runnable{
    private int number = 1;
    @Override
    public void run(){

        while (true){
            synchronized (this) {//快捷键 ：ctrl + alt + t
                                 //this ：表示Number的对象

                notify();//省略了this ：表示Number的对象。  且需要和synchronized使用同一监视器，this或其他对象

                if(number <= 10){

                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" +number);
                    number++;

                    //wait使得调用如下wait()方法的线程进入阻塞状态
                    //同时！ 🔒打开。
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }

    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number c = new Number();

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
