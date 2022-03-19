package com.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：线程池
 *
 *  1.提高相应速度
 *  2.降低资源消耗
 *  3.便于线程管理
 *      corePoolSize:核心池大小
 *      maximumPoolSize:最大线程数
 *      keepAliveTime:线程没有任务时最多保持多长时间后会停止
 *
 * @create 2021-10-10 11:02
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            if(i % 2 == 0){//偶数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            if(i % 2 != 0){//奇数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);//创建10个线程池
        ThreadPoolExecutor S1 = (ThreadPoolExecutor) service;// ThreadPoolExecutpr子类实现于父类ExecutorService
                                                            //强转service于子类S1,就能调用子类的属性方法：向下转型

        //设置线程池的属性
//        S1.setCorePoolSize(15);
//        S1.setKeepAliveTime(100);//活跃的时间


        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());
//      service.submit();//适合适用于Callable

        service.shutdown();//关闭线程池
    }
}
