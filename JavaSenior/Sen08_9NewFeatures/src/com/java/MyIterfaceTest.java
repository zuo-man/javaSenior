package com.java;

/**
 * @create 2021-11-04 20:18
 */
public class MyIterfaceTest implements MyInterface {
    @Override
    public void methdoAbstract() {
    }
    @Override
    public void methodDefault() {
        System.out.println("实现类重写了接口中的默认方法");
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();
        //接口的实现类的对象不能调用接口的静态方法
        //MyInterfaceTest.methodStatic();

        MyIterfaceTest m1 = new MyIterfaceTest();
        m1.methodDefault();

        //接口的私有方法，不能在接口外部调用
        //m1.methodPrivate();
    }
}
