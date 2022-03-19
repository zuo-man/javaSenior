package com.mybatis.test;

import com.mybatis.mapper.ParameterMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /**
     * MyBaits获取参数值的两种方式：${}  #{}
     * ${}：本质字符串拼接
     * #{}：本质占位符赋值
     * MyBatis获取参数值的各种情况：
     *      1.mapper接口方法的参数为单个的字面量类型
     *      可以通过${} 和 #{}以任意的名称获取参数，但是需要注意${}的单引号问题
     *      2.mapper接口的参数为多个时
     *      此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *          以arg0,arg1...为键，以参数为值
     *          以param1,param2...为键，以参数为值
     *      因此只需要通过#{} ${}以键的方式访问值即可，但是需要注意${}的单引号问题
     *      3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     *      因此只需要通过#{} ${}以键的方式访问值即可，但是需要注意${}的单引号问题
     *      4.mapper接口方法的参数是实体类类型的参数
     *      只需要通过#{} ${}以属性的方式访问属性即可，但是需要注意${}的单引号问题
     *
     *      5.使用@Param注解命名参数
     *      此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *          以@Param注解的值为键，以参数为值
     *          以param1,param2...以键，以参数为值
     *      因此只需要通过#{} ${}以键的方式访问值即可，但是需要注意${}的单引号问题
     *
     *
     */

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("小优", "123");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.inserUser(new User(null, "朱诺", "123", 12, "女", "112@"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "小优");
        map.put("password", "123");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("小优", "123");
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("小优");
        System.out.println(user);
    }

    @Test
    public void testgetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();

        list.forEach(user -> System.out.println(user));
    }

    //通过JDBC查询数据库，一般用占位符方式，字符串拼接方式麻烦且会SQL注入问题
    @Test
    public void testJDBC() throws Exception{
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = ?");
        ps.setString(1, username);
    }
}
