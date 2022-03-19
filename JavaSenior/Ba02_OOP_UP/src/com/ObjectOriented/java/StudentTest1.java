
package com.ObjectOriented.java;

import java.util.Arrays;

/*
 * 对象数组
 * 定义Student，包含三个属性：学号number（int），年级state（int），成绩score（int）。
 * 		创建20个学生对象，学号为1到20，年级和成绩都随机生成
 * 		1：打印3年级（static值为3）的学生信息
 * 		2：使用冒泡排序按学生成绩拍，并遍历所有学生信息
 * 
 * 
 * 此代码是对StudenTest.java的改进：将操作数组的功能封装到方法中
 * 
 */

public class StudentTest1 {
	
	public static void main(String[] args) {
		
		Student1[] stus = new Student1[20];//String[] arr = new String
		
		for(int i =0; i < stus.length; i++) {
			//给元素赋值
			stus[i] = new Student1();
			//给student对象的属性赋值
			stus[i].number = (i+1);
			//年级：[1,6]
			stus[i].state = (int)(Math.random() *(6 - 1+1)+1);
			//成绩：[0,100]
			stus[i].score = (int)(Math.random() *(100 - 0 +1));
		}	
		
		
		StudentTest1 test = new StudentTest1();
		//遍历学生数组
		test.bianli(stus);
		
		System.out.println("***********");
		
		//打印x年级学生信息
		test.searchState(stus, 2);
		
		System.out.println("***********");
		
		//排序
		test.sort(stus);
		test.bianli(stus);

	}
	
	
	
	
	
	//遍历Student1[]数组的操作
	public void bianli(Student1[] stus) {
		for(int i =0;i <stus.length; i++) {
			System.out.println(stus[i].info());
		}
	}
	
	//查找Stduent数组中指定年级的学生信息
	public void searchState(Student1[] stus,int state) {
		for(int i =0; i <stus.length;i++) {
			if(stus[i].state == state) {
				System.out.println(stus[i].info());
			}
		}
	}
	
	//给Student1数组排序
	public void sort(Student1[] stus) {
		for(int i =0;i <stus.length -1;i++) {
			for(int j =0;j <stus.length -1-i;j++) {
				if(stus[j].score > stus[j +1].score) {
					//如果需要换序，交换的是数组的元素：Student对象
					Student1 temp =stus[j];
					stus[j] =stus[j + 1];
					stus[j + 1] = temp; 
				}
			}
		}
	}


}



class Student1{
	int number;//学好
	int state;//年级
	int score;//成绩
	
	//显示数组信息的方法，直接输出会（stus[i]）调用地址值
	public String info() {
		return "学号：" + number + ", 年级：" +state + " ,成绩："+ score;
	}
	
	
}