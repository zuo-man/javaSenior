
package com.ObjectOrientedx1.java;

import java.sql.Date;

public class ValueTransferTest2 {
	
	public static void main(String[] args) {
		
		Data data = new Data();
		
		data.m = 10;
		data.n = 20;
		
		System.out.println("m = "+data.m+", n = "+ data.n);
		
		//交换两个变量的值
//		int temp = data.m;
//		data.m = data.n;
//		data.n = temp;
		
		ValueTransferTest2 test= new ValueTransferTest2();
		test.swap(data);//调用swap方法，把上面data实参传递给下面swap方法中data形参
		System.out.println("m = "+data.m+", n = "+ data.n);

		
	}
	public void swap(Data data) {
		int temp = data.m;
		data.m = data.n;
		data.n = temp;
	}
	

}


class Data{
	int m;
	int n;
}