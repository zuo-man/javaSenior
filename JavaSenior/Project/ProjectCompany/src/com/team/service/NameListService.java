package com.team.service;

//import static com.team.service.Data.*;导包后，以下调用data包的代码，Data.xxx Data就可以省略
import com.team.domain.*;

/**
 * @Description	负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @version
 * @date 2021年10月3日下午3:11:51
 */

public class NameListService {
	private Employee[] employees;//创建数组
	
	/**
	 * 此构造器给employees及数组元素进行初始化
	 */
	public NameListService() {
	/*	此构造器需要执行的：
	 * 	1.据项目提供的Data类构建相应大小的employees数组
	 * 	2.根据Data类中的数据构建不同的对象，包括：Employee、Programmer、Designer和
	 * 		Architect对象，以及相关联的Equipment子类的对象
	 * 	3.将对象存于数组中	
	 */
		employees = new Employee[Data.EMPLOYEES.length];//调用Data中employee数组的长度，建立数组
		
		for(int i = 0;i < employees.length;i++) {
			//获取员工的类型
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);//二维数组，取出数组中的第一个元素。
											  					//因为是String类型的，所以转换成int类型	
			//获取Employee的4个基本信息
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);//获取Data中的第一个信息
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			
			Equipment equipment;//只声明，不获取
			double bonus;
			int stock;
			
			switch(type) {
			case Data.EMPLOYEE://type若是10，则对应Data中的员工
				employees[i] = new Employee(id,name,age,salary);//new一个员工对象
				break;
			case Data.PROGRAMMER://type若是11，则对应Data中的程序员
				equipment = createEquipment(i);//获取Data中设备
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case Data.DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name ,age, salary, equipment, bonus);
				break;
			case Data.ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
			
		}
		
	}
	
	/**
	 * @Description	获取指定index上的员工的设备，再在传给上方new对象的代码中
	 * 				index指某一个员工，对应Data第几位，再和Data中的设备相对应
	 * @dage 2021年10月3日下午4:01:08
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int index) {

		int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);
		
		String Xmodel = Data.EQUIPMENTS[index][1];//取第二个元素
		
		switch(key) {
		case Data.PC://如果是PC，则对应Data的21，new一个PC
			String display = Data.EQUIPMENTS[index][2];
			return new PC(Xmodel, display);		
		case Data.NOTEBOOK://22
			double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
			return new NoteBook(Xmodel, price);
		case Data.PRINTER://23
			String type = Data.EQUIPMENTS[index][2];
			return new Printer(Xmodel, type);
		}
		return null;
	}

	/**
	 * @Description	获取当前所有员工
	 * @dage 2021年10月3日下午4:47:06
	 * @return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	/**
	 * @Description	获取指定ID的员工对象
	 * @dage 2021年10月3日下午4:48:19
	 * @param id
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0;i < employees.length;i++){
			if(employees[i].getId() == id){
				return employees[i];
			}
		}
		//若没找到，抛异常
		throw new TeamException("找不到指定的员工");
	}
	
	
}
