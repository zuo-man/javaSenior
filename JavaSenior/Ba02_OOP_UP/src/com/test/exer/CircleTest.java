
package com.test.exer;



public class CircleTest {

	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		
		c1.radius = 2;
		
		//对应方式一
//		double x = c1.findArea();
//		System.out.println(x);
		
		
		//对应方式二
		c1.findArea();
		
		
	}
	
}

class Circle{
	
	//属性
	double radius;
	
	//求圆的面积
	//方式一
//	public double findArea() {
//		double area = Math.PI * radius*radius;
//		return area;
//	}
	
	//方式二
	public void findArea() {
		double area = Math.PI * radius*radius;
		System.out.println(area);
	}
	
	
	
}