package com.ObjectOriented2.java;

/*
 * this 关键字使用：
 * 1.this可以用来修饰：属性、方法、构造器
 * 
 * 2.this修饰属性和方法：
 * 		当前对象 或 当前正在创建的对象
 * 		
 * 		2.1在类的方法中，我们可以使用”this.属性“或this.方法”的方式，调用当前对象属性或方法。但是通常情况下
 * 			我们都选择省略：this.”。特殊情况下。如果方法的形参和类的属性同名时，我们必须显式的使用“this.变量”
 * 			的方式，表明变量是属性，而非形参。
 * 		2.2在类的构造器中，我们可以使用”this.属性“或this.方法”的方式，调用当前正在创建的对象属性或方法。但是通常情况下
 * 			我们都选择省略：this.”。特殊情况下。如果构造器的形参和类的属性同名时，我们必须显式的使用“this.变量”
 * 			的方式，表明变量是属性，而非形参。
 * 
 * 3.this调用构造器
 * 		①在类的构造器中，可以显式的使用”this（形参列表）“的方式，调用本类中指定的其他构造器
 * 		②构造器中不能通过”this（形参列表）“方式调用自己
 * 		③一个类中有n个构造器，则最多有n-1个构造器使用了”this（形参列表）“。不然会形成死循环
 * 		④规定：”this（形参列表）“必须声明在当前构造器的首行
 * 		⑤构造器内部，最多只能声明一个”this（形参列表）“，用来调用其他的构造器
 * 
 */


public class ThisTest {
	public static void main(String[] args) {
		
		PersonTest p1 = new PersonTest();
	
		p1.setAge(1);
		System.out.println(p1.getAge());
		
		p1.eat();
		
		PersonTest p2 = new PersonTest("Tom",123);
		System.out.println(p2.getName()+p2.getAge());
		
		
	}
}

class PersonTest{
	
	private String name;
	private int age;
	
	//构造器
	public PersonTest() {
		this.eat();
		String info = "Person初始化时，需要考虑如下的1，2，3，4，，，（共40行代码）";
		System.out.println(info);
	}
	public PersonTest(String name) {
		this();//调用上方代码，就不用重复写info语句
		this.name = name;
	}
	
	public PersonTest(int age) {
		this();
		this.age = age;
	}
	
	public PersonTest(String name, int age) {
		this(age);//调用上方方法，上方方法再调用上上方方法，执行info语句
		this.name = name;
		//this.age = age;//this（age）后，此代码可省略
	}
	
	//方法
	public void setName(String name) {
		this.name = name;
	}
//	public void setName(String n) {//形参名不同时，this可以省略
//		n = name;
//	}
	
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public void eat() {
		System.out.println("人吃饭");
		study();
	}
	public void study() {
		System.out.println("人学习");
	}
}