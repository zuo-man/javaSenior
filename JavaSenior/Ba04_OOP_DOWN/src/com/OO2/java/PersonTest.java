package com.OO2.java;

/*
 * 	抽象类的匿名子类
 */

public class PersonTest {
	
	public static void main(String[] args) {
	
		Worker worker = new Worker();
		method1(worker);//非匿名的类非匿名的对象
		
		method(new Student());//匿名对象
					
		method1(new Worker());//非匿名的类匿名的对象
		
		
		//创建了一匿名子类的对象：p
		//为了省事，不用创建新的类
		Person p = new Person() {
			@Override
			public void walk() {
				System.out.println("跑");	
			}	
		};	
		method1(p);
		
		//创建匿名子类的匿名对象
		method1(new Person() {
			public void walk() {
				System.out.println("飞快的跑");	
			}
		});
		
	}
	
	public static void method1(Person p) {
		p.walk();
	}
	
	public static void method(Student s) {
		s.walk();
	}	
}

//创建新的类
class Worker extends Person{

	@Override
	public void walk() {
		System.out.println("走哇");	
	}
	
}