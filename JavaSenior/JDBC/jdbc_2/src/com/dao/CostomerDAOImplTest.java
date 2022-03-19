package com.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.bean.Customer;
import com.util.JDBCUtils;

/*
 * CustomerDAOImpl的测试
 */
public class CostomerDAOImplTest {
	
	private CustomerDAOImpl dao = new CustomerDAOImpl();

	@Test
	public void testInset() {//用try-catch
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Customer cust = new Customer(1, "丽达", "123@", new Date(2000-02-23));
			dao.inset(conn, cust);
			
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testDeleteById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();

			dao.deleteById(conn, 13);

			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testUpdateById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Customer cust = new Customer(10,"奈乐","23@",new Date(3234234L));
			dao.updateById(conn, cust);

			System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetCustomerById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionDruid();//使用Druid数据库连接池技术
			
			Customer cust = dao.getCustomerById(conn, 22);
			System.out.println(cust);


			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}	}

	@Test
	public void testGetAll() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			List<Customer> list = dao.getAll(conn);
			list.forEach(System.out::println);

			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}	}

	@Test
	public void testGetCount() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			Long count = dao.getCount(conn);

			System.out.println("表中的记录数为:" + count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}	}

	@Test
	public void testGetMaxBirth() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();

			Date maxBirth = dao.getMaxBirth(conn);

			System.out.println("最大生日为：" + maxBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, null);
		}	
	}

}
