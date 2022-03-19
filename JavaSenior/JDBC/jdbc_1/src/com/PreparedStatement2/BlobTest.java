package com.PreparedStatement2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.Preparedstatement.Customer;
import com.util.JDBCUtils;

/**
 * @Description 测试使用PreparedStatement操作Blob数据
 * @version
 * @date 2021年11月20日下午1:14:24
 */
public class BlobTest {
	//向数据表customers中插入Blob类型的字段
	@Test
	public void testInsert() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into customers(name,email,birth,photo)value(?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, "唯");
		ps.setObject(2, "123@");
		ps.setObject(3, "2000-03-04");
		FileInputStream is = new FileInputStream(new File("234.png"));
		ps.setBlob(4, is);
		
		ps.execute();
		
		JDBCUtils.closeResource(conn, ps);
	}
	
	
	//查询数据表customers中Blob类型的字段
	@Test
	public void testQuery(){//try-catch
		Connection conn = null;
		PreparedStatement ps = null;
		InputStream is = null;
		FileOutputStream fos = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select id, name ,email, birth, photo from customers where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 22);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				//方式一：
	//			int id = rs.getInt(1);
	//			String name = rs.getString(2);
	//			String email = rs.getString(3);
	//			Date birth = rs.getDate(4);
				//方式二：
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				
				Customer cust = new Customer(id, name, email, birth);
				System.out.println(cust);
				
				//将Blob类型的字段下载下来，以文件的方式保存在本地
				Blob photo = rs.getBlob("photo");
				is = photo.getBinaryStream();
				fos = new FileOutputStream("wei.png");
				byte[] buffer = new byte[1024];
				int len;
				while((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(is != null)
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(is != null)
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JDBCUtils.closeResource(conn, ps, rs);
		}
	}
}




