package com.OO.java;
/*
 * 	类的成员四：代码块
 * 
 * 	1.作用：用来初始化类、对象
 * 	2.代码块如果有修饰的话，只能使用static
 * 	3.执行先于构造器
 * 
 * 	3.分类：
 * 		
 * 		静态代码块：
 * 			>作用：初始化类的信息
 * 			>内部可以有输出语句
 * 			>随着类的加载而执行，并且只执行一次
 * 			>静态代码块先于非静态代码块执行
 * 			>静态代码块内只能调用静态的属性、方法，不能调用非静态的结构
 * 
 * 		非静态代码块：
 * 			>作用：可以在创建对象时，对对象的属性等进行初始化
 * 			>内部可以有输出语句
 * 			>随着对象的创建而执行，每创建一个对象，就执行一次非静态代码块
 * 			>非静态代码块内可以调用静态的属性、方法，或非静态的属性、方法
 * 
 *  
 * 	对属性可以赋值的位置：
 * 	①默认初始化
 * 	②显式初始化 / ⑤在代码块中赋值
 * 	③构造器中的初始化
 * 	④有了对象之后，通过“对象 . 属性”或“对象 . 方法”进行赋值
 * 
 * 
 * 	执行先后顺序：① - ② / ⑤ - ③ - ④
 * 
 */

public class BlockTest {
	public static void main(String[] args) {
		
		String desc = Person.desc;
		System.out.println(desc);
		
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.age);
		
	}
}


class Person{
	
	String name;
	int age;
	static String desc = "我是人";
	
	//构造器
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//代码块
	//static静态
	static{
		System.out.println("静态");
		desc = "我是一个爱学习的人";
	}
	
	{
		System.out.println("非静态");
		age = 1;
	}
	
	
	
	//方法
	public void eat() {
		System.out.println("吃饭");
	}
	public static void bigeat() {
		System.out.println("干饭");
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}	
	
}
