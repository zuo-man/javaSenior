package com.java1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * @author
 * @create
 */

interface Human{

    String getBelief();

    void eat(String food);
}
//被代理类
class SuperMan implements Human{


    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("====================通用方法一====================");

    }

    public void method2(){
        System.out.println("====================通用方法二====================");
    }

}

    /*
    需要解决的两个主要问题：
        问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。 （通过Proxy.newProxyInstance()实现）

        问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。 (通过InvocationHandler接口的实现类及其方法invoke())
    */
class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
          //(下方的Object：表明代理类对象的类型是Object)
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象  :表明此时创建的代理类是用来代理哪个被代理类的（此时创建的代理类是用来代理obj传过来的被代理类）
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);//给被代理类对象赋值

        //obj.获取哪个类加载的, obj.代理类和被代理类实现同样的接口
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),  obj.getClass().getInterfaces(),  handler);
    }

}

class MyInvocationHandler implements InvocationHandler {//定义一个InvocationHandler接口的实现类

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){//实例化被代理类的对象
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
                      //(Object 代理类的对象，Method  代理类调用的方法，同名方法参数args）
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj,args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return returnValue;

    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();//创建被代理类对象superMan
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");

        System.out.println("*****************************");

        Star s1 = new Star();//创建被代理类对象s1

        Cloth c = (Cloth) ProxyFactory.getProxyInstance(s1);

        c.Work();
    }
}
