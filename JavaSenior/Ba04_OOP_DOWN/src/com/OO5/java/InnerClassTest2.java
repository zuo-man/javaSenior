package com.OO5.java;

/*	
 * 	内部类：
 * 	4.3开发中局部内部的使用
 */

public class InnerClassTest2 {
	
	//返回一个实现了Comparable接口的类的对象
	public Comparable getComparable() {
		
		//方式一
//		class MyComparable implements Comparable{
//
//			@Override
//			public int compareTo(Object o) {
//				return 0;
//			}	
//		}
//		return new MyComparable();
		
		//方式二,匿名
		return new Comparable() {

			@Override
			public int compareTo(Object o) {
				return 0;
			}
			
		};
			
		
		
	}	
}
