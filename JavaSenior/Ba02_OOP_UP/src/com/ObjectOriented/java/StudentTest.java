
package com.ObjectOriented.java;

import java.util.Arrays;

/*
 * 对象数组
 * 定义Student，包含三个属性：学号number（int），年级state（int），成绩score（int）。
 * 		创建20个学生对象，学号为1到20，年级和成绩都随机生成
 * 		1：打印3年级（static值为3）的学生信息
 * 		2：使用冒泡排序按学生成绩拍，并遍历所有学生信息
 * 
 */

public class StudentTest {
	
	public static void main(String[] args) {
		
		Student[] stus = new Student[20];//String[] arr = new String
		
		for(int i =0; i < stus.length; i++) {
			//给元素赋值
			stus[i] = new Student();
			//给student对象的属性赋值
			stus[i].number = (i+1);
			//年级：[1,6]
			stus[i].state = (int)(Math.random() *(6 - 1+1)+1);
			//成绩：[0,100]
			stus[i].score = (int)(Math.random() *(100 - 0 +1));
		}
		
		//遍历学生数组
		//1.用for调用方法遍历
//		for(int i =0;i <stus.length; i++) {
//			System.out.println(stus[i].number + "," +stus[i].state
//					+ "," +stus[i].score);
//		}
		
		//2.用方法遍历
		for(int i =0;i <stus.length; i++) {
			System.out.println(stus[i].info());
		}
		
		//打印3年级（static值为3）的学生信息
		for(int i =0; i <stus.length;i++) {
			if(stus[i].state == 3) {
				System.out.println(stus[i].info());
			}
		}
		
	}


}



class Student{
	int number;//学好
	int state;//年级
	int score;//成绩
	
	//显示数组信息的方法，直接输出会（stus[i]）调用地址值
	public String info() {
		return "学号：" + number + ", 年级：" +state + " ,成绩："+ score;
	}
	
	
}