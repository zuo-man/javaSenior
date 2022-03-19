                                   
package com.test.java;

/*
 * 算法考察：数组的复制、反转、查找（线性查找、二分法查找）
 * 
 */


public class ArrayTest4 {
	
	public static void main(String[] args) {
		
		String[] arr = new String[] {"JJ","DD","NN","MM"};
		
		//数组的复制（区别与数组变量的赋值：arr1 = arr）
		String[] arr1 = new String[arr.length];
		
		for(int i = 0;i < arr1.length;i++) {
			arr1[i] =arr[i];
		}
		
		
		  
		//数组的反转
		//方法一：
//		for(int i = 0;i < arr.length/2; i++) {
//			String temp =arr[i];
//			arr[i]= arr[arr.length -i-1];
//			arr[arr.length-i-1] = temp;
//		}
		//方法二：
		for(int i =0,j = arr.length -1;i < j; i++,j--) {
			String temp1 =arr[i];
			arr[i] =arr[j];
			arr[j] =temp1;
		}	
		//遍历
		for(int i =0;i < arr.length; i++) {
			System.out.print(arr[i] +"\t");
		}
		
		
		
		
		//查找（或搜索）
		//线性查找
		String dest= "MM";
		
		boolean isFlag=true;
		
		for(int i =0; i < arr.length;i++) {

			if(dest.equals(arr[i])) {
				System.out.println("指定元素位置为：" +i);
				isFlag =false;
				break;
			}
		}
		if(isFlag) {
			System.out.println("没有找到");
		}
		
		
		//二分法查找：
		//所要查找的数组必须有序
		int[] arr2 = new int[] {-34,-12,-3,3,34,123,355,666};
		
		int dest1 = -34;
		int head =0;//初始的首索引
		int end =arr2.length -1;//初始的末索引
		boolean isFlag1 =true;
		
		while(head <= end) {
			
			int middle = (head + end)/2;
			
			if(dest1 == arr2[middle]) {
				System.out.println("指定位置为：" + middle);
				isFlag1 = false;
				break;
			}else if(arr2[middle] >dest1) {
				end =middle -1;
			}else {//arr2[middle] <dest1
				head = middle +1;
			}
			
		}
		
		if(isFlag1) {
			System.out.println("没有找到");
		}
		
		
		
		
	}
	
}
