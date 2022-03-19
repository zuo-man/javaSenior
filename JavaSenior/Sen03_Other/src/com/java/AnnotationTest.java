package com.java;

import java.util.ArrayList;

/**
 * 注解
 *
 * 一.Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，
 *      并执行相应的处理，可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 *
 * 二.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在
 *      JacaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，
 *      代替JacaEE旧版中所遗留的繁琐代码和XML配置等
 *
 * 三.Annotation使用实例
 *      1：生成文档相关的注解
 *      2：在编译时进行格式检查（JDK内置的三个基本注解）
 *      * @Override：限定重写父类方法，该注解只能用于方法
 *      * @deprecated：用于表示所修饰的元素（类，方法等）已过时，
 *      * @SuppressWarnings：抑制编译器警告
 *
 *      3：跟踪代码依赖性，实现代替配置文件功能
 *
 *  四.jdk提供的4种元注解
 *      元注解：对现有的注解进行解释说明的注解
 *
 *      Retention：指明所修饰的Annotation的生命周期：SOURCE/CLASS(默认行为）/RUNTIME
 *              只有声明为RUNTIME生命周期的注解，才能通过反射获取
 *      Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
 *      **以下出现频率低**
 *      Documented：表示所修饰的注解在被jacadoc解析时，保留下来
 *      Inherited：被它修饰的Annotation将具有继承性
 *
 *   五.新特性：
 *      可重复注解：①：在MyAnnotatin上声明@Repeatable，成员值为MyAnnotation2.class
 *                ②：MyAnnotation的Target和Retention等元注解与MyAnnotation2相同
 *
 *      类型注解：
 *          ElementTYpe.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
 *          ElementTYpe.TYPE_USE 表示该注释能卸载使用类型的任何语句中
 *
 *
 * @create 2021-10-17 15:23
 */
public class AnnotationTest {
    public static void main(String[] args) {

        @SuppressWarnings("unused") //警告注解：num未被使用
        int num = 10;

    }
}

@MyAnnotation(value = "hello")//value指定了默认值，所以可以省略value = "hello"
@MyAnnotation(value = "hi")
class Person{
    private String name;

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
    }

    public void walk(){
        System.out.println("走路");
    }
}

class Student extends Person{
    @Override
    public void walk() {
        System.out.println("跑 ");
    }
}

class Generic<@MyAnnotation T>{

    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 11L;

    }

}
