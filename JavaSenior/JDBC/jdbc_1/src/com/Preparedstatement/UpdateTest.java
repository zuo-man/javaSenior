package com.Preparedstatement;

import java.util.Scanner;

import org.junit.Test;

//测试通用增删改查
public class UpdateTest {
	@Test
	public void testupdate() throws Exception {
		PerparedStatementUpdataTest p1 = new PerparedStatementUpdataTest();
//		String sql = "delete from customers where id = ?";
//		p1.update(sql,12);
		
		String sql = "update `order` set order_name = ? where order_id = ?";
		p1.update(sql,"DD","2");
	}
	@Test
	public void testupdate1() throws Exception {
		PerparedStatementUpdataTest p1 = new PerparedStatementUpdataTest();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = scanner.next();
		System.out.println("请输入邮箱：");
		String email = scanner.next();
		System.out.println("请输入生日：");
		String birthday = scanner.next();//'2000-02-02
		
		String sql = "insert into customers(name,email,birth)values(?,?,?)";
		int in = p1.update(sql,name,email,birthday);
		if(in > 0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void testcustomers() throws Exception {
		CustomerForQuery c1 = new CustomerForQuery();
		
		String sql = "select id, name, birth, email from customers where id = ?";
		Customer customer = c1.queryForCustomers(sql, 19);
		System.out.println(customer);
		
		sql = "select name,email from customers where name = ?";
		Customer customer1 = c1.queryForCustomers(sql, "周杰伦");
		System.out.println(customer1);
	}
	
	@Test
	public void testOrder() throws Exception{
		OrderForQuery o1 = new OrderForQuery();
		
		String sql = "select order_id as orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = o1.orderForQuery(sql, 1);
		System.out.println(order);
	}
}
