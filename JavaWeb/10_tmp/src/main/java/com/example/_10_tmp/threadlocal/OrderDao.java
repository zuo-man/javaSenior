package com.example._10_tmp.threadlocal;

public class OrderDao {

    public void saveOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderDao 当前线程[" + name + "]中保存的数据是：" + ThreadLocalTest.threadLocal.get());
    }

}
