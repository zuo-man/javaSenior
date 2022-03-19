package com.OO2.java;

public class Student extends Person {

	String major;
	
	public Student() {
		
	}
	public Student(String major) {
		this.major = major;
	}
	
	public void study() {
		System.out.println("学习，专业是：" + major);
	}
	
	
	//对父类中的eat（）方法进行重写：
	public void eat() {
		System.out.println("有营养");
	}
	
	//②
	//父类中私有方法private，不是重写
	public void show() {
		System.out.println("我是学生");
	}
	//③
	public String info() {
		return null;
	}
}
