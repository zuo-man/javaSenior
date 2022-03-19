package com.Object.java;

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理：从键盘输入学生成绩，找出最高分，并输出学生成绩等级
 * 	  数组一旦创建，长度就固定不变，而向量类Vector可以根据需要动态伸缩
 * 
 * 
 */

public class ScoreTest {
	public static void main(String[] args) {
		
		//1.实例化Scanner，用于从键盘获取学生成绩
		Scanner scan = new Scanner(System.in);//ctrl+shift+o 快捷键导包
		
		//2.创建Vector对象：相当于原来的数组
		Vector v = new Vector();
		
		//3.通过for或者while，给Vector中添加数组
		int maxScore = 0;
		for(;;) {
			System.out.println("请输入学生成绩（负数输入结束）");
			int score = scan.nextInt();
			//3.2当输入是负数时，跳出循环
			if(score<0) {
				break;//跳出for循环
			}
			if(score>100) {
				System.out.println("输入数据非法");
				continue;//跳出此if循环，继续执行for循环语句
			}
			//3.1添加操作   
			//之前操作
//			Integer inScore = new Integer(score);
//			v.addElement(inScore);//多态
			//自动装箱操作
			//v.addElment(Object obj)向向量添加元素，obj必须是对象
			v.addElement(score);//自动装箱    就能用属性.方法
			
			//4.获取学生成绩的最大值
			if(maxScore < score) {
				maxScore =score;
			}	
		}				
		
		//5.遍历Vecotr。得到每个学生成绩，并输出等级
		char level;
		for(int i = 0; i< v.size(); i++) {//v.seze()计算向量v的长度
			Object obj = v.elementAt(i);//v.elementAt取出向量v中的元素
			
//			//之前操作
//			Integer inScore = (Integer)obj;//对象Obj转换为包Integer类型
//			int score = inScore.intValue();//包Integer类型转换为int类型
			//之后操作
			int score = (int)obj;
					
			if(maxScore - score <=10) {
				level = 'A';
			}else if(maxScore - score <=20) {
				level = 'B';
			}else if(maxScore - score <=30) {
				level = 'C';
			}else {
				level = 'D';
			}
			
			System.out.println("最大值为："+maxScore);
			System.out.println("学生" + i + "成绩为： " + score + ",等级为：" + level);
		}
		
	}
}
