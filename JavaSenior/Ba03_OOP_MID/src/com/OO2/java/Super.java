package com.OO2.java;

public class Super {
	
	String name;
	int age;
	int id = 1001;//身份证号
	
	public Super() {	
	}
	public Super(String name) {
		this.name = name;
	}
	public Super(String name,int age) {
		this(name);
		this.age = age;
	}
	
	public void eat() {
		System.out.println("吃饭");
	}
	public void walk() {
		System.out.println("人走路");
	}

}
