package com.PreparedStatement2;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import com.Preparedstatement.Customer;
import com.Preparedstatement.Order;
import com.util.JDBCUtils;

/**
 * @Description 使用PreparedStatement实现针对于不用表的通用的查询操作，返回一条记录
 * @version
 * @date 2021年11月19日下午5:20:50
 */
public class PreparedStatementQueryTest {
		  //<T>泛型方法叫T
	public <T> T getInstance(Class<T> clazz,String sql, Object... args) throws Exception {//用try-catch
		// 1.获取数据库的连接
		Connection conn = JDBCUtils.getConnection();

		// 2.预编译sql语句，返回PerparedStatement的实例
		PreparedStatement ps = conn.prepareStatement(sql);
		// 3.填充占位符
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}

		ResultSet result = ps.executeQuery();
		// 获取结果集的元数据
		ResultSetMetaData re = result.getMetaData();
		// 通过ResultSetMetaData获取结果集中的列数
		int colum = re.getColumnCount();

		if (result.next()) {
			T t = clazz.getDeclaredConstructor().newInstance();// 创建泛型T对象，准备赋值

			// 处理结果集一行数据中的每一个列
			for (int i = 0; i < colum; i++) {
				// 获取列值
				Object columValue = result.getObject(i + 1);

				// 获取每个列列名
//						String columnName = re.getColumnName(i + 1);
				String columnLabel = re.getColumnLabel(i + 1);

				// 给t对象指定的columnName属性，赋值为columValue：通过反射
				Field f = clazz.getDeclaredField(columnLabel);
				f.setAccessible(true);
				f.set(t, columValue);
			}
			return t;
		}
		JDBCUtils.closeResource(conn, ps, result);

		return null;
	}
	
	
	//测试
	@Test
	public void test() throws Exception {
		String sql = "select id ,name , email from customers where id = ?";
		Customer customer = getInstance(Customer.class,sql,19);
		System.out.println(customer);
		
		String sql1 = "select order_id orderId, order_name orderName from `order` where order_id = ?";
		Order order = getInstance(Order.class,sql1 , 1);
		System.out.println(order);
	}
}




