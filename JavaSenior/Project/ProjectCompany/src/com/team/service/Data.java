package com.team.service;

//装数据，一般在数据库中

public class Data {
	public static final int EMPLOYEE = 10;//员工
	public static final int PROGRAMMER = 11;//程序员
	public static final int DESIGNER = 12;//设计师
	public static final int ARCHITECT = 13;//架构师
	
	public static final int PC = 21;
	public static final int NOTEBOOK = 22;
	public static final int PRINTER = 23;
	
	//Employee    : 10, id, name, age, salary工资
	//Programmer  : 10, id, name, age, salary
	//Designer    : 10, id, name, age, salary, bonus奖金
	//Architect   : 10, id, name, age, salary, bonus, stock股票
	public static final String[][] EMPLOYEES = {
			{"10","1","苏小真","22","3000"},
			{"13","2","千 姬","23","7000","15000","2000"},
			{"11","3","时无忧","16","17000"},
			{"11","4","时无暇","17","15000"},
			{"11","5","丽 达","33","3000"},
			{"12","6","聂诗柔","42","12000","2000"},
			{"11","7","伊珂丝","10","6000"},
			{"13","8","奈 乐","27","7000","4000","3000"},
			{"12","9","格兰尼","18","8000","15000"},
			{"11","10","洛可可","19","9000"},
			{"11","11","沐 恩","32","12000"},
			{"12","12","艾 琳","31","11000","4500"},
	};
	
	//如下的EQUIPMENTNTS数组与上面的EMPLOYUEES数组元素一一对应
	//PC	    :21, model机器型号 ,  display显示器
	//NoteBook	:22, model, price价格
	//Printer	:23, name,  type类型
	public static final String[][] EQUIPMENTS = {
			{},//第一个员工没有设备
			{"22","联想","4999"},
			{"21","戴尔","10寸"},
			{"21","戴尔","4寸"},
			{"23","华硕","大大大电脑"},
			{"21","电脑A","3寸"},
			{"21","电脑B","34寸"},
			{"23","电脑C","小电脑"},
			{"22","电脑D","5000"},
			{"21","戴尔","6寸"},
			{"21","华硕","2寸"},
			{"22","电脑A","4000"},
	};

}



