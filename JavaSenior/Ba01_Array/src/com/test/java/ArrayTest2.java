

/*
 * 二维数组
 * 
 */


package com.test.java;

public class ArrayTest2 {
	
	public static void main(String[] args) {
		
		//1.二维数组的声明和初始化
		int[] arr = new int[]{1,2,3};//一维数组
		
		//静态初始化
		int[][] arr1 = new int[][] {{1,2,3},{5,6},{6,7,8}};
		//动态初始化1
		String[][] arr2 = new String[3][2];
		//动态初始化2
		String[][] arr3 = new String[3][];
		
		//错误写法
		//int[][] arr6 = new int[6][4] {{1,2,3},{5,6},{6,7,8}};
		//String[][] arr4 = new String[][2];
		//String[3][4] arr5 = new String[][];

		//这也是正确写法
		int [] arr4[] = new int[][] {{1,2,3},{5,6},{6,7,8}};
		int [] arr5[] = {{1,2,3},{5,6},{6,7,8}};
		
		
		//2.调用数组指定元素
		System.out.println(arr1[0][1]);//调用arr1第一个数组的第二个数组元素   2
		System.out.println(arr2[1][1]);//null	
		
		arr3[1] = new String[4];
		System.out.println(arr3[1][0]);
		
		
		
		//3.获取数组的长度
		System.out.println(arr4.length);//3
		System.out.println(arr4[1].length);//2
		
		
		//4.遍历二维数组
		for(int i = 0;i < arr4.length;i++) {
			
			for(int j =0; j <arr4[i].length;j++) {
				System.out.print(arr4[i][j] +" ");
			}
			System.out.println();
		}
		
		
		
		
		
	}
	
}
