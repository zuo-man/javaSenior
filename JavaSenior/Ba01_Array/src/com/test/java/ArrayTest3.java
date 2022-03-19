
package com.test.java;

/*
 * 二维数组初始化
 * 
 * 1.规定：二维数组分为外层数组的元素，内层数组的元素
 * 		int[][] arr = new int[4][3];
 * 		外层元素：arr[0],arr[1]等
 * 		内层元素：arr[0][0],arr[1][2]等
 * 
 * 2.初始化值：
 * 		初始化方式1：
 * 		int[][] arr = new int[4][3];
 * 		外层元素的初始化值为：地址值
 * 		内层元素的初始化值为：与一维数组初始化情况相同
 * 	 	
 * 		初始化方式2：
 * 		int[][] arr = new int[4][];
 * 		外层元素的初始化值为：null
 * 		内层元素的初始化值为：不能调用，否则报错
 * 	
 * 
 * 
 */

public class ArrayTest3 {

	public static void main(String[] args) {
		
		int[][] arr = new int[4][3];
		System.out.println(arr[0]);//[I@15db9742地址值
		System.out.println(arr[0][0]);//0
		
		//System.out.println(arr);//[[I@15db9742地址值
	
		
		System.out.println("****");                          
		float[][] arr1 = new float[4][3];
		System.out.println(arr1[0]);//地址值
		System.out.println(arr1[0][0]);//0.0
		
		
		System.out.println("****");                          
		String[][] arr2 = new String[4][3];
		System.out.println(arr2[1]);//String地址值
		System.out.println(arr2[1][1]);//null
		
		
		System.out.println("****");                          
		String[][] arr3 = new String[4][];
		System.out.println(arr3[1]);//null
		System.out.println(arr3[1][0]);//报错：空指针异常
		
		
		
		
	}
	
	
	
}
