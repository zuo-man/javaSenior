package com.team.junit;

import com.team.domain.Employee;
import com.team.service.NameListService;
import com.team.service.TeamException;
import org.testng.annotations.Test;

/**
 * 对NameListService类的测试
 * @Description
 * @version
 * @date 2021年10月3日下午4:59:55
 */

public class NameListServiceTest {

	//测试获取全部信息
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i <employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	//测试获取某一个
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		int id = 1;
		id = 10;
		
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		}catch(TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
