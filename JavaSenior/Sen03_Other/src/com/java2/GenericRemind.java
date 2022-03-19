package com.java2;

/**
 * @create 2021-10-22 14:27
 */
public class GenericRemind{
    public static void main(String[] args) {
        SubOrder S1 = new SubOrder();
        //由于子类在继承带泛型父类是，指明了泛型类型，则实例化子类对象时，不再需要指明泛型类型
        S1.setT(123);
    }
    //静态方法中不能使用类的泛型（类的泛型实例化的时候体现，而静态结构早于对象的创建）
//    public static void show(T t){
//        System.out.println(t);
//    }
}

class SubOrder extends Order<Integer>{
    //继承自定义泛型类，指明了泛型T是Inerger类型，之后实例化时，就不用声明泛型类型了。
    //SubOrder就不是泛型类了，只是普通的类
}
class SubOrder1<T> extends Order<T>{
    //继承与自定义泛型类，没有指明T类型。则SubOrder1仍然是泛型类
}

//异常类不能是泛型
//class MyExentionT<T> extends Excention{
//}

class Father<T1,T2>{
}
//子类不保留父类的泛型
// 1)没有类型 擦除
class Son1 extends Father {// 等价于class Son extends Father<Object,Object>{}
}
// 2)具体类型
class Son2<A,B> extends Father<Integer, String> { }//定义了父类的泛型。同时也定义了自己的泛型A,B

//子类保留父类的泛型
// 1)全部保留
class Son3<T1, T2> extends Father<T1, T2> { }
// 2)部分保留
class Son4<T2> extends Father<Integer, T2>{ }

