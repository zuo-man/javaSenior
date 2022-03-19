package com.OO2.java;

public class Person {

	String name;
	int age;
	
	public Person() {
		
	}
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	
	//方法
	 void eat() {
		System.out.println("吃饭");
	}
	public void walk(int distance) {
		System.out.println("走路，走的公里是：" + distance + "公里");
		//eat进行了重写
		eat();
		//show没有进行重写
		show();
	}
	
	//②
	private void show() {
		System.out.println("我是人");
	}
	//③
	public Object info() {
		return null;
	}
}
