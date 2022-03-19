package com.OO2.java;

public class Super1 extends Super{
	
	String major;
	//父子类都有id，内存中有两个id，属性不会像方法一样会覆盖
	int id = 10;//学号
	
	public Super1() {
		//默认调用父类，只是一般省略
		super();
	}
	public Super1(String major) {
		this.major = major;
	}
	public Super1(String name,int age,String major) {
//		this.name = name;
//		this.age = age;
		//调用父类的属性
		super(name,age);
		this.major = major;
	}
	
		
	
 	@Override
	public void eat() {
		System.out.println("有营养");
	}
	
	public void study() {
		System.out.println("学习");
		this.eat();
		super.eat();
	}
	
	public void show() {
		System.out.println("name = " + this.name +",age = "+ super.age);
		//默认调用字类
		System.out.println("id = " +this.id);
		//调用父类
		System.out.println("id = " + super.id);
	}	
}
