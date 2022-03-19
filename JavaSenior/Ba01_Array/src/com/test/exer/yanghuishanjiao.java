
package com.test.exer;

/*
 * 杨辉三角
 * 1.第一行1个元素，第n行n个元素
 * 2.每一行的第一个元素和最后一个元素都是1
 * 3.从第三行开始，对于非第一个元素和最后一个元素为：上个元素+上左个元素=这个元素
 * 
 */

import java.util.Scanner;

public class yanghuishanjiao {

	public static void main(String[] args) {
		
		
		Scanner scan =new Scanner(System.in);
		System.out.println("请输入行数");
		int hang= scan.nextInt();
		
		//1.声明并初始化动态二维数组
		int[][] sanjiao= new int[hang][];
		
		//2.给数组元素赋值（第一行一个元素，第二行两个元素、、、）
		for(int i =0; i <sanjiao.length;i++) {
			sanjiao[i] = new int[i + 1];
			
			
			//2.1给首末元素赋值为1
			sanjiao[i][0]=1;
			sanjiao[i][i]=1;
			//2.2给非首末元素赋值
			if(i>1) {
				for(int j =1;j<sanjiao[i].length-1;j++) {
					sanjiao[i][j] = sanjiao[i-1][j-1] + sanjiao[i-1][j];
				}
			}
			
		}
		
		
		//3.遍历二维数组
		for(int i =0; i<sanjiao.length;i++) {
			for(int j =0; j<sanjiao[i].length;j++) {
				System.out.print(sanjiao[i][j]+" ");
				
			}
			System.out.println();
		}
		
		
		
		
	}
	
}
