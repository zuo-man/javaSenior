package com.OO.java;

//static关键字使用

public class CircleTest {
	public static void main(String[] args) {
		
		Circle c1 = new Circle();//调用不带参构造器
		Circle c2 = new Circle();
		
		Circle c3 = new Circle(3.3);//调用带参构造器
		
		System.out.println("c1的id:" + c1.getId());
		System.out.println("c2的id:" + c2.getId());
		

		System.out.println("创建圆的个数为：" + Circle.getTotal());//用“类 . 静态变量”的方式进行调用静态变量total
		
	}			
}


class Circle{
	
	private double radius;
	private int id;//自动赋值
		
	private static int total;//创建圆的个数
	private static int init = 001;//static声明的属性被所有的对象所共享
	
	//构造器
	public Circle() {
		//用户使用此构造器造对象
		id = init++;//公共init，使得每次调用+1
		total++;
	}
	
	public Circle(double radius) {
//		this();也能用this直接调用上方构造器，就不用写下下方两个相同代码
		this.radius = radius;
		//用户使用此构造器造对象
		id = init++;
		total++;
	}

	
	//getset方法
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public int getId() {
		return id;
	}
	
	public static int getTotal() {
		return total;
	}
	
}