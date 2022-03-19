package com.exer;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @create 2021-10-09 17:21
 */
public class SingletonTest {
}
class Bank{
    //懒汉式单例模式
    //1.私有化类的构造器
    private Bank(){
    }
    //2.内部创建类的的对象
    //4.要求此对象也必须声明为静态
    private static Bank instance = null;

    //3.提供公共静态的方法调用，并返回类的对象
    public static  Bank getInstance(){
        //方式一：效率较低
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance= new Bank();
//            }
//            return instance;
//        }
        //方式二：效率稍高
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null){
                    instance= new Bank();
                }
             }
        }
        return instance;
    }

}