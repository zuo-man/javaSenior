package com.java1;

/**
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了
 *
 * @create 2021-10-30 15:14
 */
interface Cloth{
    void Work();
}
//代理类
class Again implements Cloth{
    private Cloth matter;//用被代理类对象进行实例化

    public Again(Cloth matter){
        this.matter = matter;
    }

    @Override
    public void Work() {
        System.out.println("开始代理");

        matter.Work();//此时相当于：xing.Work();

        System.out.println("结束代理");
    }
}
//被代理类
class Star implements Cloth{
    @Override
    public void Work() {
        System.out.println("干活");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类对象
        Star xing = new Star();
        //创建代理类对象
        Again a = new Again(xing);

        a.Work();
    }
}

