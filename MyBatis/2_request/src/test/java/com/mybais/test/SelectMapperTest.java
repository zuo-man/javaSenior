package com.mybais.test;

import com.mybais.mapper.SelectMapper;
import com.mybais.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {

    /**
     * MyBatis各种查询功能
     * 1.若查询数据只有一条
     *      通过实体类对象或者集合接受
     *      通过List集合接受
     *      通过Map集合接受，以字段为键，以字段对应的值为值
     *
     * 2.若查询数据有多条
     *      通过实体类类型的List集合接受
     *      通过Map类型的list集合接受
     *      可以在mapper接口方法上添加 @MapKey注解，此时可以将每条数据转换为map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接受，此时体会抛异常TooManyResultsException
     *
     * MyBaits中设置了默认的类型别名
     *  Java.lang.Integer --> int, integer
     *  int --> _int, _integer
     *  Map --> map
     *  String --> string
     */

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(1));
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetUserByIdMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdMap(1));
    }

    @Test
    public void testGetAllUserMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserMap());
    }
}
