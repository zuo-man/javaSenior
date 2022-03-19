package com.example.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @create 2021-12-12 12:31
 */
public class JdbcUtils{
    /**
     * 获取数据库连接池中的连接
     *
     * ThreadLocal 的作用，它可以解决多线程的数据安全问题。
     * ThreadLocal 它可以给当前线程关联一个数据（可以是普通变量，可以是对象，也可以是数组，集合）
     * ThreadLocal 的特点：
     *      1、ThreadLocal 可以为当前线程关联一个数据。（它可以像 Map 一样存取数据，key 为当前线程）
     *      2、每一个 ThreadLocal 对象，只能为当前线程关联一个数据，就可以在整个项目中只使用一个提交线程，每次get(conn)
     *      当前数据库连接，只会调用此连接对象，结合事务从而解决要么都提交数据，要么回滚数据
     *
     *      如果要为当前线程关联多个数据，就需要使用多个ThreadLocal 对象实例。
     *      3、每个 ThreadLocal 对象实例定义的时候，一般都是 static 类型
     *      4、ThreadLocal 中保存数据，在线程销毁后。会由 JVM 虚拟自动释放
     */
    private static DruidDataSource source;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static{
        try {
            Properties pros = new Properties();

//            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            pros.load(is);

            source = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 获取连接
     */
    public static Connection getConnection(){
        Connection conn = conns.get();

        if ( conn == null ){  //若第一次没有连接，则调用source.getConnection()获取连接
            try {
                conn = source.getConnection(); //从数据库连接池中获取连接

                conns.set(conn); //保存到ThreadLocal对象中，供后面的JDBC操作使用

                conn.setAutoCommit(false); //设置为手动管理事务

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }


    /** 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get(); //获取连接对象
        if (connection != null ) {  //不等于null，说明之前使用过此连接，操作过数据库
            try {

                connection.commit(); //提交事务
                connection.close(); //关闭连接，提交资源

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 一定要执行remove操作，否则会出错，因为Tomacat服务器底层使用了线程池技术
        conns.remove();
    }


    /** 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get(); //获取连接对象
        if (connection != null ) {  //不等于null，说明之前使用过此连接，操作过数据库
            try {

                connection.rollback(); //回滚事务
                connection.close(); //关闭连接，提交资源

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 一定要执行remove操作，否则会出错，因为Tomacat服务器底层使用了线程池技术
        conns.remove();
    }

//    /** 关闭连接，放回数据库连接池
//     */
//    public static void close(Connection conn){
//        if(conn != null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
