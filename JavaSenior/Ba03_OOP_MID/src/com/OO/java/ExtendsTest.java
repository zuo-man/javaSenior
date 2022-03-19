package com.OO.java;

/*
 * 	面向对象特征之二：继承性	extends:延展、扩展
 * 	
 * 	①减少了代码的冗余，提高了代码的复用性
 * 	②便于功能的扩展
 * 	③为之后多态性的使用，提供了前提
 * 
 * 	一：继承性格式：class A extends B{}
 * 		A：字类、派生类、subclass
 * 		B：父类、超类、基类、superclass
 * 
 * 		1 体现：一旦字类A继承父类B以后，字类A中就获取了父类B声明的所有属性和方法。
 * 		  特别的：父类中声明为private的属性或方法，字类继承父类之后，仍然认为获取了父类中私有的结构
 * 		 只是因为封装性的影响，使得字类不能直接调用父类的结构而已
 * 
 * 		2 字类继承父类以后，还可以声明自己特有的属性或方法，实现功能的拓展。
 * 		字类和父类的关系，不同与子集和集合的关系。
 * 	
 * 	二：规定：
 * 		1.一个类可以被多个字类继承。
 * 		2.Java中类的单继承性：一个类只能有一个父类
 * 		3.子父类是相对的概念
 * 		4.字类直接继承的父类，称为：直接父类。以上继承，间接继承的父类称为：间接父类
 * 		5.字类继承父类以后，就获取了直接父类以及所有间接父类声明的属性和方法
 * 
 * 	三：1.如果没有显式的声明一个类的父类，则此类继承于java.lang.Object类
 * 	   2.所有的java类（除java.lang.Object类之外）都直接或间接的继承于java.lang.Object类
 * 	   3.意味着：所有的Java类都具有java.lang.Object类声明的功能		
 * 
 */



public class ExtendsTest {
	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.age=1;
		p1.eat();
		
		Student s1 = new Student();
		s1.eat();
		s1.sleep();
		
		
	}
	

}
