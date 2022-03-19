
package com.ObjectOrientedx1.java;

/*
 * 递归方法：
 * 1.一个方法体内调用它自身
 * 2.方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无需循环控制。
 * 	   递归一定要向已知方向递归，否则这种递归就变成了无穷递归，成死循环
 * 
 */


public class RecursionTest {

	public static void main(String[] args) {
		
		//计算1-100之间所有自然数的和
		//方式一：
		int sum =0;
		for(int i =1; i <=100;i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		//方式二：
		RecursionTest test = new RecursionTest();
		int sum1 = test.getSum(100);
		System.out.println(sum1);
		
		//匿名对象（只调用一次）
		System.out.println(test.getchen(9));
		
		System.out.println(test.f(10));
		
		System.out.println(test.fei(7));
	}
	
	//递归
	//计算1-100之间所有自然数的和
	public int getSum(int n) {
		if(n==1) {
			return 1;
		}else {
			return n+ getSum(n - 1);
		}
	}
	
	//计算1-n之间所有自然数的乘积：n！
	public int getchen(int n) {
		if(n==1) {
			return 1;
		}else {
			return n* getchen(n - 1);
		}
	}
	
	//已知有一个数列：f(0)=1,f(1)=4,f(n+2)=2*f(n+1)+f(n),
	//其中n是大于0的整数，求f(10)的值
	public int f(int n) {
		if(n==0) {
			return 1;
		}else if(n==1) {
			return 4;
		}else {
			//错误：return f(n+2)-2 * f(n+1);
			return 2*f(n - 1) +f(n - 2);
		}	
	}
	
	//斐波那契数列 
	//1 1 2 3 5 8 13 21 
	//除前两项，一个数等于前两个数之和
	public int fei(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 1;
		}else {
			return fei(n-1)+fei(n-2);
		}	
	}
}
