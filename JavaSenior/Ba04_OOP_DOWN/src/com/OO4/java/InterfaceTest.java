package com.OO4.java;

public class InterfaceTest {
	public static void main(String[] args) {
		
		SubClass s = new SubClass();
		
//		s.method1();
//		SubClass.method1();
		//1.口中定义的静态方法，只能通过接口来调用
		Interface8.method1();
		
		//2.通过实现类的对象，可以调用接口中的默认方法
		//如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写之后的方法
		s.method2();
		//3.如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法，
		//那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法 ---->类优先原则
		//4.如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法
		//的情况下，报错 ---->接口冲突，这就必须在实现类中重写此方法
		s.method3();
		
		System.out.println("*********");	
		s.mymethod();
	}
}


//继承父类,同时实现接口
class SubClass extends SuperClass implements Interface8{
	
	//重写默认方法
	public void method2() {
		System.out.println("DDDD");
	}
	
	//5.如何在子类（或实现类）的方法中调用父类、接口中被重写的方法
	public void mymethod() {
		method3();//调用自己定义重写的方法
		super.method3();//调用的是父类中声明的方法
		//调用接口中默认方法
		Interface8.super.method3();
	}
	
}

//定义一个父类
class SuperClass {
	public void method3() {//与接口默认方法3同名
		System.out.println("SSSS");
	}
}