package com.ERR.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 	异常处理方式二：throws + 异常类型
 * 
 * 	1."throws + 异常类型" 写在方法的声明处。指明此方法执行时，可能会抛出的异常类型
 * 		一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足
 * 		throws后异常类型时，就会被抛出
 * 	2.throws 异常代码后续的代码，将不在执行
 * 
 * 	3.try：真正将异常处理了
 * 	  thorws:只是将异常抛给了方法调用者，并没有真正将异常处理掉
 * 
 * 	如何选择：
 * 	4.1如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，
 * 		意味着如果子类重写的方法中有异常，必须使用try方式处理
 * 	4.2执行的方法A中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。则建议使用
 * 		throw的方式进行处理。则执行的方法A中可以考虑try方式进行处理
 * 
 */

public class ExceptionTest2 {
	
	public static void main(String[] args) {
		try {
			method2();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void method2() throws IOException{
		
	}
	
	public void method1() throws FileNotFoundException,IOException{
		File file = new File("hello.txt");
		FileInputStream fis = new FileInputStream(file);
		
		int data = fis.read();
		while(data != -1) {
			System.out.println((char)data);
			data = fis.read();
		}
		fis.close();
		
		System.out.println("啊啊啊啊啊啊啊啊啊");
	}

}
