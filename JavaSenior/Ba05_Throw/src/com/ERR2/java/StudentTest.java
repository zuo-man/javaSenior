package com.ERR2.java;

/*
 * 	手动抛出异常 ：throw
 */


public class StudentTest {
	public static void main(String[] args) {
		
		try {
			Student s = new Student();
			s.regist(-10);
			System.out.println(s);
		} catch (Exception e) {
//			e.printStackTrace();	
			System.out.println(e.getMessage());//e.getMessage()调用35行代码
		}
		
	}
}

class Student{
	
	private int id;
	
	public void regist(int id) throws Exception {
		if(id > 0) {
			this.id = id;
		}else {
//			System.out.println("输入数据非法1");
			//手动抛出异常
//			throw new RuntimeException("输入的数据非法2");//运行时异常
//			throw new Exception("输入数据非法3");//编译和运行时异常
			throw new MyException("不能输入负数");
			
		}
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}

	
}