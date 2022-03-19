
package com.test.java;


/**
 * 1.数组的理解。是对多个相同类型数据按一定排列的集合，并使用一个名字命名。
 * 并通过编号的方式对这些数据进行统一管理
 * 
 * 2.数据概念
 *   数据名
 *   元素
 *   角标、下标、索引
 *   数组的长度；元素的个数
 *  
 * 3.特点：数组是有序排列的
 *	  	    数组的长度一旦确定，就不能修改
 *		    创建数组对象会在内存中开辟一整块连续的空间
 *		    数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型
 *
 * 4.分类：按维度：一维数组，二维数组，，，，
 * 		    按数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组
 * 
 * 
 *  
 */


public class ArrayTest {
	
	public static void main(String[] args) {
		
		//1.一维数组的声明和初始化
		int num;//声明
		num = 10;//初始化
		int id = 1001;//声明+初始化
		
		int[] ids;//声明
		//1.1 静态初始化：数组的初始化和数组元素的赋值操作 同时 进行
		ids = new int[] {2,3,4,5};
		//1.2动态初始化：数组的初始化和数组元素的赋值操作 分开 进行
		int[] namee = new int[4];
		String[] names = new String[4];
		
		//这也是正确写法
		int[] arr4 = {1,2,3,4};//类型推断
		
		/*
		 错误写法：
		 int[] arr1= new int[];
		 int[6] arr2= new int[6];
		 int[] arr3= new int[3]{2,3,4};
		 */
		
		//总结：数组一旦初始化完成，其长度就确定了
		
		//2.通过角标的方式调用数组指定位置的元素
		//数组的角标（或索引）从0开始，到数组的长度-1结束。
		
		names[0] = "小优";
		names[1] = "小暇";
		names[2] = "小真";
		names[3] = "小千";
		
		//3.获取数组的长度
		//属性：length
		System.out.println(names.length);//4
		
		//4.遍历数组
		/*
		 * System.out.println(names[0]); 
		 * System.out.println(names[1]);
		 * System.out.println(names[2]); 
		 * System.out.println(names[3]);
		 */
		for(int i =0; i <names.length; i++) {
			System.out.println(names[i]);
		}
		
		
		
	}

}
