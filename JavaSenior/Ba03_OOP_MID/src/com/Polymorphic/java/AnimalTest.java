package com.Polymorphic.java;

import java.sql.Connection;

//多态性的使用举例一
//多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法

public class AnimalTest {
	
	public static void main(String[] args) {
		
		AnimalTest test = new AnimalTest();
		test.func(new Dog());
		
		test.func(new Cat());
		
		
	}

	//Animal是父类，调用了与子类相同的方法，执行和操作的是子类的方法
	public void func(Animal animal) {//Animal animal = new Dog();
		animal.eat();
		animal.shout();
		
		if(animal instanceof Dog) {
			Dog d = (Dog)animal;
			d.watchDoor();
		}
	}
	
}

class Animal{
	public void eat() {
		System.out.println("动物：进食");
	}
	public void shout() {
		System.out.println("动物：叫");
	}
}

//子类继承上面父类
class Dog extends Animal{
	public void eat() {
		System.out.println("🐕吃骨头");
	}
	public void shout() {
		System.out.println("汪");
	}	
	public void watchDoor() {
		System.out.println("看门");
	}
}

class Cat extends Animal{
	public void eat() {
		System.out.println("🐱吃🐟");
	}
	public void shout() {
		System.out.println("喵");
	}
}


//举例二：
class Order{
	public void method(Object obj) {
		
	}
}

//举例三：
class Driver{
	public void doDate(Connection conn) {//conn = new MySQlConnection();  执行和操作的是MYSQl中的方法，
										//也就不用重新new一个MYSQl
		//规范的步骤去操作数据
//		conn.method1();
//		conn.method2();
//		等等，调用mysql重写的方法，子类也就执行了
	}
}