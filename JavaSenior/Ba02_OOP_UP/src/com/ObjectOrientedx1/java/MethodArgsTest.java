
package com.ObjectOrientedx1.java;

/*
 * 可变形参
 * 	1.可变个数形参的格式： 数据类型 ... 变量名
 *  2.当调用可变个数形参方法时，传入的参数个数可以说：0个，1个，2个，，，，，
 *  3.可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
 *  4.可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载，二者不能同时存在
 *  5.可变个数形参在方法的形参中，必须声明在末尾，且最多只能声明一个可变形参
 * 
 */

public class MethodArgsTest {  
	
	public static void main(String[] args) {
		
		MethodArgsTest test = new MethodArgsTest();
		
		test.show(23);
		test.show("hellow");
		test.show("2","23","wer","wef","d","wd");
		
	}
	
	
	public void show(int i) {
		System.out.println("1");
	}
	
	public void show(String s) {
		System.out.println("2");
	}
	
	public void show(String ... strs) {
		System.out.println("3");
		for(int i =0; i<strs.length;i++) {
			System.out.print(strs[i]+"  ");
		}
	}
	
	//和上方     形参类型也相同的数组之间不构成重载，二者不能同时存在
	//public void show(String[] strs) {
		
	//}
	

}
