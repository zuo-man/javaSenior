package com.OO2.java;

/*
 * 	abstract（抽象的）关键字的使用
 * 	1.abstract可以用来修饰：类、方法
 * 
 * 	2.abstract修饰类：
 * 		>此类不能实例化
 * 		>抽象类中一定有构造器，便于子类实例化时调用
 * 		>抽象类不能使用final关键字声明，因为子类要继承
 * 		>开发中，都会提供抽象的子类，让子类对象实例化
 * 
 *	3.abstract修饰方法：
 *		>抽象方法只有方法的声明，没有方法体
 *		>包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法 
 *		>若子类重写了父类中的所有的抽象方法后，此子类方可实例化
 *		  若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要abstract修饰
 * 		
 */

public class AbstractTest {
	public static void main(String[] args) {
		
		//一旦Person类抽象了，就不可实例化
//		Person p1 = new Person();		
//		p1.eat();
		
	}
}

abstract class Person{
	String name;
	int age;
	
	//虽然父类不能实例化，但子类依然要调用父类的构造器
	public Person(){	
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("吃饭");
	}

	//抽象方法
	public abstract void walk();
	
	
}


class Student extends Person{
	//调用父类构造器 
	public Student() {
	}
	public Student(String name, int age) {
		super(name,age);
	}
	
	//因为父类walk是抽象方法，子类继承后，要么重写walk方法，要么抽象化子类Student
	public void walk() {
		System.out.println("快走");
	}
}
