package com.exer;

/**
 * 银行有一个账户
 * 两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 *
 * 分析：
 *  多个线程：两个储户
 *  共享数据：公用同一个账户
 *  有线程安全问题
 *
 * @create 2021-10-09 19:43
 */
class Account {
    private double balance;

    public Account(double q) {//double q = 1
        this.balance = q;//double的balance = q = 1
    }

    //存钱
    public synchronized void deposot(double amt){//double amt = 1000;
        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread{

    private Account AA;

    public Customer(Account V) {//在构造器中给属性acct实例化  Account V = acct
        this.AA = V;
    }

    @Override
    public void run(){
        for(int i = 0;i < 3;i++){
           AA.deposot(1000);
        }
    }
}

public class BankTest {
    public static void main(String[] args) {
        Account acct = new Account(1);//创建一个acct的账户，且令初始账户一快钱

        Customer c1 = new Customer(acct);//在类Customer创建一个c1对象，同时把acct赋值给V
        Customer c2 = new Customer(acct);//将此对象acct作为参数传递到Customer类的构造器中，创建Customer类的对象

        c1.setName("A");
        c2.setName("B");

        c1.start();
        c2.start();
    }
}
