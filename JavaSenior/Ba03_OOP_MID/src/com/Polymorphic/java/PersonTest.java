package com.Polymorphic.java;

/*
 * 	面向对象特征之三：多态性
 * 
 * 		1.可以理解为一个事物的多种形态。
 * 		    对象的多态性：父类的引用指向字类的对象（或子类的对象赋给父类的引用）
 * 		    对象的多态性：只适用于方法，不适用于属性（编译和运行都看左边）、
 * 
 * 		2.多态性的使用前提：①类的继承关系 	②方法的重写
 * 
 * 		3.多态的使用：虚拟方法调用
 * 		   有了对象的多态性之后，在编译期，只能调用父类中声明的方法，但在运行期，实际执行的是子类重写父类的方法
 * 		   编译看左，运行看右
 * 
 * 
 */ 

public class PersonTest {
	public static void main(String[] args) {
		
		//对象的多态性：父类的引用指向字类的对象
		Person p1 = new Man();
	
		
		//多态的使用：当调用子父类同名同参数的方法时，实际执行的是字类重写父类的方法---->虚拟方法调用
		//编译看左，运行看右
		p1.eat();
		p1.walk();
		
		System.out.println(p1.id);//100父类中的
		
		System.out.println("*********");
		
		//不能调用子类所特有的方法，编译时，p2是Person型
//		p2.earnMoney();
//		p2.isSmoking = ture;
		//多态性之后，内存中实际是加载了子类特有的属性和方法，但是由于变量声明为父类类型，导致
		//编译时，只能调用父类中声明的属性和方法。 子类特有的属性和方法不能调用。
		
		//如何才能调用子类特有的属性和方法？
		//向下转型：使用强制类型转换
		Man m1 = (Man)p1;
	
		//使用强转时，可能出现ClassCastException的异常
//		Woman w1 = (Woman)p1;
//		w1.goShopping();
		
		/*
		 * instanceof关键字的使用
		 * 
		 * a instanceof A:判断对象a是否是类A的实列。 若是：返回true，若不是：返回false。
		 * 
		 * 使用情景：为了避免出现异常，在向下转型之前，先进行instanceof判断。返回ture向下转型。返回false，不进行向下转型
		 * 
		 * 如果 a instanceof  A返回ture，则a instanceof B也返回true
		 */
		if(p1 instanceof Woman) {
			Woman w1 = (Woman)p1;
			w1.goShopping();
			System.out.println("买");
		}
		if(p1 instanceof Man) {
			Man m2 = (Man)p1;
			m2.earnMoney();
			System.out.println("挣");
		}
		if(p1 instanceof Person) {
			System.out.println("1");
		}
		if(p1 instanceof Object) {
			System.out.println("2");
		}
		
		
	}
}
