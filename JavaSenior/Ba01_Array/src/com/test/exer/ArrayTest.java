

package com.test.exer;

/*
 * 定义一个int型的一维数组，包换10个元素，分别赋一些随机两位整数，然后求出所有元素
 * 的最大值、最小值、和值、平均值
 * 
 */


import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		
		System.out.println("请输入数组中元素的个数");
		Scanner scan = new Scanner(System.in);
		int shuzu = scan.nextInt();
		
		int[] yiwei = new int[shuzu];
		
		for(int i=0; i<yiwei.length;i++) {
			yiwei[i] = (int)(Math.random()*90 + 10);
			System.out.println("为：" + yiwei[i]);
		}
		
		
		int x=yiwei[0];
		for(int i=0; i<yiwei.length;i++) {
			if(x<yiwei[i]) {
				x=yiwei[i];

			}
		}
		System.out.println("最大值为："+x);
		
		
		int y=yiwei[0];
		for(int i=0; i<yiwei.length;i++) {
			if(y>yiwei[i]) {
				y=yiwei[i];

			}
		}
		System.out.println("最小值为"+y);
		
		
		int sum=0;
		for(int i=0; i<yiwei.length;i++) {
			sum +=yiwei[i];
			
		}
		System.out.println("和为"+sum);
		
		
		int p=sum/yiwei.length;
		System.out.println("平均数为：" +p);
		
		
		
	}
	
	
	
}



