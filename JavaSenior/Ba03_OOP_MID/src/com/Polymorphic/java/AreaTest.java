package com.Polymorphic.java;

//多态性练习

public class AreaTest {
	
	public static void main(String[] args) {
	
		AreaTest test = new AreaTest();
		
		Area c1 = new Area(2, "blue", 2.0);
		test.display(c1);
		Area c2 = new Area(4, "blue", 2.0);
		test.display(c2);
		
		boolean isEqulas = test.equalsArea(c1, c2);
		System.out.println(isEqulas);
		
	}	
	
	
	//测试面积
	public void display(AreaMianji o) {//AreaMianji o = new Area(...);多态性
		System.out.println("面积为：" + o.findArea());
	}
	//测试两个对象的面积是否相等
	public boolean equalsArea(AreaMianji o1,AreaMianji o2) {
		return o1.findArea() == o2.findArea();
	}

}
