
package com.ObjectOriented.java;

public class ArrayUtilTest {

	public static void main(String[] args) {
		
		ArrayUtil util = new ArrayUtil();
		int[] arr = new int[] {2,23,43,-34,-444,4,554,7,8,9,0};
		int max =util.getMax(arr);
		System.out.println("最大值为：" + max);
		
		System.out.println("排序前：");
		util.print(arr);
		
		util.sort(arr);
		System.out.println("排序后：");
		util.print(arr);
		
	}
	
}
