

package com.test.java;

/*	 一维数组的初始化
 * 		
 * 5.数组元素的初始化值：
 * 		数据元素是整型：0
 * 		数组元素是浮点型：0.0
 * 		数组元素是char型：0,而非'0'
 * 		数组元素是boolean型：false.true
 * 		
 * 		数组元素是引用数据类型：null
 */




public class ArrayTest1 {
	
	public static void main(String[] args) {
		//5.数组元素的默认初始化值
		//整型
		int[] arr = new int[4];
		for(int i = 0; i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("*******");
		
		
		//整型
		short[] arr1 = new short[4];
		for(int i = 0; i < arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("*******");
		
		
		//浮点型
		float[] arr2 = new float[4];
		for(int i = 0; i < arr2.length;i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("*******");
		
		
		//char字符型
		char[] arr3 = new char[4];
		for(int i = 0; i < arr3.length;i++) {
			System.out.println("---"+arr3[i]+"---");
		}
		if(arr3[0]==0) {
			System.out.println("hew");
		}
		System.out.println("*******");
		
		
		//boolean型
		boolean[] arr4 = new boolean[4];
		System.out.println(arr4[0]);
		System.out.println("*******");
		
		
		
		
		String[] arr5 = new String[5];
		System.out.println(arr5[0]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
