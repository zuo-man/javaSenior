

package com.test.exer;

/*
 *  从键盘输入学生成绩。找出最高分，并输出学生等级
 */

import java.util.Scanner;


public class ArrayDemo1 {
	public static void main(String[] args) {
		
		//1.canner。读取学生个数
		Scanner scan =new Scanner(System.in);
		System.out.println("请输入学生个数:");
		int number = scan.nextInt();
		
		
		//2.创建数组，存储学生成绩，动态初始化
		int[] chenji =new int[number];
		
		
		//3.给数组中的元赋值
		System.out.println("输入"+number+"个学生成绩");
		for(int i= 0; i < chenji.length;i++) {
			chenji[i] = scan.nextInt();
		}
		
		//4.获取数组中的元素的最大值：最高分
		int maxScore = 0;
		for(int i = 0; i < chenji.length;i++) {
			if(maxScore < chenji[i]) {
				maxScore = chenji[i];
			}
		}
		System.out.println("最高分为："+maxScore);
		
		
		//5.根据每个学生成绩与最高分的插值，得到每个学生的等级，并输出等级和成绩
		char level;
		for(int i =0; i < chenji.length;i++) {
			if(maxScore - chenji[i] <= 10) {
				level = 'A';
			}else if(maxScore - chenji[i] <= 20) {
				level = 'B';
			}else if(maxScore - chenji[i] <= 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			
			
			System.out.println("学生 "+i+"成绩是 "+ chenji[i] +",等级为："+level);
			
			
		}
		
		
		
		
		
	}
}
