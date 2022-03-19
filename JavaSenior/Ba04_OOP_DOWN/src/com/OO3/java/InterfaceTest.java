package com.OO3.java;

/*
 * 	接口：
 * 	1.接口使用interface定义
 * 	2.java中，接口和类是并列的两个结构
 * 	3.如何定义接口：定义接口中的成员
 * 
 * 		3.1 JDK7及以前，只能定义全局常量和抽象方法
 * 			>全局常量：public static final，书写时，可省略
 * 			>抽象方法：public abstract,书写时，可省略
 * 
 * 	4.接口中不可定义构造器：意味着接口不可实例化
 * 
 * 	5.接口通过让类去实现（implements）的方式来使用
 *	     如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
 *	     如果实现类中没有覆盖接口中所有的抽象方法，则此实现类仍未一个
 *
 *	6.Jave类可以实现多个接口  --->弥补了Java单继承的局限性
 *	     格式：class AA extends BB implement CC,DD,EE
 *
 *	7.接口与接口之间可以继承，而且可以多继承
 *
 *	8.接口的具体使用体现多态性，接口：实际上可以看做是一种规范
 * 
 * 
 */

public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println(Flyable.MAX_SPEED);//静态调用		
		Plane plane = new Plane();
		plane.fly();
		
	}
}

//接口
interface Flyable{
	
	//全局常量
	public static final int MAX_SPEED = 7900;//第一宇宙速度
	int MIN_SPEED = 1;//省略了public static final
	
	//抽象方法
	public abstract void fly();
	void stop();//省略了public abstract
}

interface Attackable{
	
	void attack();
	
}


//用类实现接口
class Plane implements Flyable{

	//因为接口Flyable中有抽象方法，类实现后，要么重写接口中的抽象方法，要么抽象化类Plane(加abstract）
	@Override
	public void fly() {
		System.out.println("通过引擎飞");
	}
	@Override
	public void stop() {
		System.out.println("驾驶员减速停止");
	}
}

//用类实现多个接口（若类要实例化，则需要实现接口中所有的抽象方法）
class Bullet implements Flyable,Attackable{

	@Override
	public void attack() {
		
	}
	@Override
	public void fly() {
		
	}
	@Override
	public void stop() {

	}
}




//接口的继承
interface AA{
	void method1();
}
interface BB{
	void method2();
}
interface CC extends AA,BB{
	
}






