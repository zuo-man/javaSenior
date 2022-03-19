


package com.test.exer;

	public class ArrayDemo {
		
		public static void main(String[] args) {
	
		int[] arr = new int[] {1,2,3,4,5};
		int[] index = new int[] {2,0,3,2,4,0,1,3,2,3,3};
		String tel ="";
		for(int i = 0; i <index.length; i++) {
			tel+= arr[index[i]];
		}		
		System.out.println("电话："+tel);
	}
		
}
