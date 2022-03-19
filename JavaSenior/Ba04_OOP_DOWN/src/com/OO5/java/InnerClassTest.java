package com.OO5.java;

/*
 * 	类的内部成员之五：内部类
 * 	1.Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
 * 
 * 	2.分类：	成员内部类（静态、非静态）		局部内部类（方法内、代码块内、构造器内）
 * 
 * 	3.成员内部类：
 * 		一方面，作为外部类成员：
 * 			>调用外部类的结构
 * 			>可以被static修饰
 * 			>可以被4种不同的权限修饰符修饰
 * 		另一方面，作为一个类：
 * 			>类内可以定义属性、方法、构造器等
 * 			>可以被final修饰，表示此类不能被继承，不用final，就可以被继承
 * 			>可以被abstract修饰
 * 
 * 	4.3个问题：
 * 		4.1 如何实例化成员内部类的对象
 * 		4.2如何在成员内部类中区分调用外部类的结构
 * 		4.3开发中局部内部的使用
 * 
 */

public class InnerClassTest {
	public static void main(String[] args) {
		
		//4.1 如何实例化成员内部类的对象
		//创建Dog（静态的成员内部类）
		Person.Dog dog = new Person.Dog();
		dog.sing();
		
		//创建Cat（非静态的成员内部类）
//		Person.Cat cat = new Person.Cat();//错误的。有外部类的实例之后，才能调用非静态的结构
		Person p = new Person();
		Person.Cat cat = p.new Cat();
		
		cat.sing();
		
		System.out.println();
		
		cat.display("大猫");
		
	}
}

class Person{
	String name = "小优";
	int age;
	
	public void eat() {
		System.out.println("吃饭");
	}
	
	
	//静态成员内部类
	static class Dog{
		String name;
		int age;
		
		public void sing() {
			System.out.println("🐕");
//			eat();//静态类不可调用非静态类
		}
	}
	//非静态成员内部类
	class Cat{
		String name = "猫";
		
		public Cat() {
			
		}
		
		public void sing() {
			System.out.println("🐱");
			Person.this.eat();//调用外部类方法	.Person.this可以省略
		}
		
		//4.2如何在成员内部类中区分调用外部类的结构
		public void display(String name) {
			System.out.println(name);//调用形参
			System.out.println(this.name);//调用内部类Cat的name
			System.out.println(Person.this.name);//调用外部类Person的name
		}
		
	}
	
	
	
	public void method() {
		//局部内部类
		class AA{
			
		}
	}
	
	{
		//局部内部类
		class BB{
			
		}
	}
	
	public Person() {
		//局部内部类
		class CC{
			
		}
	}
	
}



