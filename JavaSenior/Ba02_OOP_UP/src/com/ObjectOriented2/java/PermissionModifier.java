package com.ObjectOriented2.java;

import com.ObjectOriented2.java.Animal;

/*
 * 封装与隐藏和权限修饰符
 * 
 * 	1.当创建一个类的对象之后，可以通过“对象.属性”的方式，对对象赋值。此时，赋值操作要受属性
 * 	    的数据类型和存储范围的制约。除此之外，无其他制约条件。但是，在实际问题中，往往需要给
 *	    属性赋值加入额外的限制条件。这个条件就不能在属性声明时体现，只能通过方法进行限制条件
 *	    的添加。（比如set）。同时，需要用户避免对“对象.属性”的方式对属性进行赋值。则需要将
 *	    属性声明为私有的（private）
 *		  ————>此时，体现了属性的封装性
 *
 *	2.封装性的体现
 *	    将类的属性xxx私有化（private）后，提供公共的（public）方法来获取（getXxx）和
 *	    设置（setXxx）此属性的值
 *
 *	    不对外暴露的私方法、单例模式 ...
 * 
 *  3.封装性的体现，需要权限修饰符来配合。
 *    ①Java规定的4种权限（从小到大排序）：private、缺省、protected、public
 *    ②4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
 *    ③具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
 *    		 修饰类的话，只能使用：缺省、public 
 *    
 *    
 *    	四种访问权限修饰符
 * 		
 * 
 * 		修饰符		类内部		同一个包		不同包的字类		同一个工程
 * 		
 * 		private		y
 * 		缺省			y			y
 * 		protected	y			y			y
 * 		public 		y			y			y				y 
 */

public class PermissionModifier{

	public static void main(String[] args) {
		
		Animal a = new Animal();
		a.name = "大黄";
//		a.age = 1;
		
//		a.legs = 4;The field Animal.legs is not visible
		
	
		a.setLegs(12);
		
		a.show();
	}
	
}


class Animal{
	
	String name;
	private int age;
	private int legs;//私有，腿的个数
	
	//对属性的设置
	public void setLegs(int l) {
		if(l >=0 && l % 2 ==0) {//腿的个数大于0
			legs = l;
		}else {
			legs = 0;
		}
	}
	
	//对属性的获取
	public int getLegs() {
		return legs;
	}
	
	
	public void eat() {
		System.out.println("动物进食");
	}
	
	public void show() {
		System.out.println("name = " + name + ",age ="+ age +" legs= "+legs	); 
	}
	
	//提供关于属性age的get和set方法
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		age = a; 
	}
}
