package com.java;

/**
 *  创建多线程的方式二：实现Runnable接口
 *  1.创建一个实现了Runnable接口的类
 *  2.实现类去实现Runnable中的抽象方法run()
 *  3.创建实现类的对象
 *  4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *  5.通过Thread类的对象调用start()
 *
 *
 *  比较创建线程的两种方式：
 *  开发中：优先选择：实现Runnable接口的方式
 *  原因：1.实现的方式没有类的单继承性的局限性
 *       2.实现的凡是更适合处理多个线程共享的数据情况
 *
 *  联系：public class Thread implements Runnable
 *  相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
 *
 *
 * @create 2021-10-07 14:55
 */
class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread Thread = new MThread();

        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(Thread);

        //①启动线程   ②调用当前线程的run()--->调用了Runnable类型的target的run()
        t1.start();

        //在启动一个线程
        Thread t2 = new Thread(Thread);
        t2.start();
    }
}
