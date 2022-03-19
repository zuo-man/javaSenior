package com.Preparedstatement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.util.JDBCUtils;

/**
 * @Description 针对于Customers表的查询操作
 * @version
 * @date 2021年11月19日下午2:35:41
 */
public class CustomerForQuery {
	//针对于customers表通用的查询操作
		  //Customer:就返回Customer对象
	public Customer queryForCustomers(String sql,Object...args) throws Exception{//用try-catch
		//1.获取数据库的连接
		Connection conn = JDBCUtils.getConnection();
		
		//2.预编译sql语句，返回PerparedStatement的实例
		PreparedStatement ps = conn.prepareStatement(sql);
		//3.填充占位符
		for(int i = 0; i < args.length;i++) {
			ps.setObject(i+1, args[i]);
		}
		
		ResultSet result = ps.executeQuery();
		//获取结果集的元数据 
		ResultSetMetaData re = result.getMetaData();
		//通过ResultSetMetaData获取结果集中的列数
		int colum = re.getColumnCount();
		
		if(result.next()) {
			Customer cust = new Customer();//创建customer对象，准备赋值
			
			//处理结果集一行数据中的每一个列
			for(int i = 0; i < colum; i++) {
				//获取列值
				Object columValue = result.getObject(i + 1);
				
				//获取每个列列名
//				String columnName = re.getColumnName(i + 1);
				String columnLabel = re.getColumnLabel(i + 1);
				
				//给cust对象指定的columnName属性，赋值为columValue：通过反射
				Field f = Customer.class.getDeclaredField(columnLabel);
				f.setAccessible(true);
				f.set(cust, columValue);
			}
			return cust;
		}
		JDBCUtils.closeResource(conn, ps, result);
		
		return null;
	}
	
	
	
	@Test
	public void test() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select id,name,email,birth from customers where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, 18);
		
		//执行，并返回结果集
		ResultSet result = ps.executeQuery();
		//处理结果集
		if(result.next()) {//next():判断结果集的下一条是否有数据，有数据返回true，并指针下移，如果返回false，指针不会下移
			
			//获取当前这条数据的各个字段值
			int id = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3); 
			Date birth = result.getDate(4);
			
			//方式一：直接输出
//			System.out.println("id = " + id + ",name = " +name + ",email = " + email + ",birth = " + birth);
			
			//方式二：数组
//			Object[] data = new Object[] {id,name,email,birth};
			
			//方式三：将数据封装成一个对象
			Customer customer = new Customer(id, name, email, birth);
			System.out.println(customer);
		}
		
		//关闭资源
		JDBCUtils.closeResource(conn, ps, result);
	}
}
