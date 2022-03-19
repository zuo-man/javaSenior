package com.ERR.java;

import org.junit.Test;

/*
 * 	异常处理：抓抛模型
 * 	
 * 	过程一抛：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，
 * 			并将此对象抛出。一旦抛出对象以后，其后的代码就不在执行
 * 
 * 			关于异常对象的产生：①系统自动生成的异常对象
 * 						   ②手动的生成一个异常对象，并抛出（throw）
 * 
 * 	过程二抓：异常处理方式：①try-catch-finally		②throws
 * 
 * 	二：try-catch-finally的使用：
 * 	
 * 		try{
 * 			//可能出现异常的代码
 * 
 * 		}catch（异常类型1 变量名1）{
 * 			//处理异常的方式1
 * 		}catch（异常类型2 变量名2）{
 * 			//处理异常的方式2
 * 		}....
 * 		finally{
 * 			//一定会执行的代码
 *	 	}
 * 
 * 
 * 	说明：
 * 	1.finally是可选的
 * 	2.使用try将可能出现的异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象
 * 	    的类型，去catch中匹配
 * 	3.一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理，处理完成之后就跳出当前的
 * 	 try-catch结构（在没有写finally的情况）。继续执行之后代码
 * 	4.catch中的异常类型如果没有子父类的关系。则可以随意
 * 	  catch中的异常类型如果有子父类的关系，则要求子类一定声明在父类的上面
 * 	5.常用的异常对象处理方式 ： ①String	  getMessage（）		②printStackTrace（）
 *	6.在try结构中声明的变量，出了try结构后，就不可再被调用
 *	7.try-catch-finally结构可以嵌套
 *
 *
 *	开发时：由于运行时异常比较常见，所以通常就不针对运行时异常编写try
 *		     针对编译时异常，一定要考虑异常的处理c
 * 
 * 	 
 */

public class ExceptionTest1 {
	
	@Test
	public void test1() {
		String str = "123";
		str = "abc";
		try {
			int num = Integer.parseInt(str);
			
			System.out.println("11");
		}catch(NumberFormatException e){
			//方式一
//			System.out.println("出现数值转换异常");
			
			//方式二
			//String getMessage();	
			System.out.println(e.getMessage());
			
			//方式三
			//PrintStackTrace();
//			e.printStackTrace();
		}catch(NullPointerException e){
			System.out.println("出现空指针异常");
		}catch(Exception e){//Exception是上方异常的父类，需写子类下方
			System.out.println("出现异常");
		}
		
		System.out.println("22");
		
//		System.out.println(sum);
	}
	
	

}





