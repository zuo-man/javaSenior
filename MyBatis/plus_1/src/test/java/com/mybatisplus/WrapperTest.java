package com.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.desktop.QuitEvent;
import java.util.List;
import java.util.Map;

/**
 * eq ： equal等于
 * ne： not equal不等于
 * gt ： greater than大于
 * lt ： less than小于
 * ge ： greater than or equal 大于等于
 * le ： less than or equal 小于等于
 * in ： in 包含（数组）
 * isNull ： 等于null
 * between ： 在2个条件之间(包括边界值)
 * like： 模糊查询
 */

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTest(){
        //查询用户名包含 小，年龄在18~25之间，邮箱信息不为null的用户信息
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        //SELECT uid,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        Wrapper.like("user_name", "小")
               .between("age", 18, 25)
               .isNotNull("email");

        List<User> users = userMapper.selectList(Wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectList(){
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> Wrapper = new QueryWrapper<>();
        //SELECT uid,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        Wrapper.orderByDesc("age").orderByAsc("uid");

        List<User> list = userMapper.selectList(Wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void deleteTest(){
        //删除邮箱地址为 null用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL) 逻辑删除
        wrapper.isNull("email");
        int result = userMapper.delete(wrapper);
        System.out.println("result：" + result);
    }

    @Test
    public void updateTest(){
        //将年龄 (大于20并且用户名中包含有 小)，或邮箱为null的用户信息修改     默认用且（and），或用 or
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20)
               .like("user_name", "小")
               .or()
               .isNull("email");
        User user = new User();
        user.setName("无暇");
        user.setEmail("123");
        int result = userMapper.update(user, wrapper);
        System.out.println("result：" + result);
    }

    @Test
    public void updateTest2(){
        //将用户名中包含有 暇 并且（年龄大于 20 或 邮箱为null）的用户信息修改
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //lambda中的条件优先执行
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        wrapper.like("user_name", "暇")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("千姬");
        user.setEmail("123");
        int result = userMapper.update(user, wrapper);
        System.out.println("result：" + result);
    }

    //查询特定字段，其他字段不查
    @Test
    public void select2(){
        //查询用户的用户名、年龄、邮箱信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        wrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    //子查询
    @Test
    public void select3(){
        //用子查询 查询id小于等于10的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //相当于： select * from t_user where uid in (select uid from t_user where uid <= 10)
        wrapper.inSql("uid", "select uid from t_user where uid <= 10 ");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    //updateWrapper 实现修改
    @Test
    public void updateWrapper1(){
        //将用户名中包含有 千 并且（年龄大于 20 或 邮箱为null）的用户信息修改
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("user_name", "千")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        //修改为：
        wrapper.set("user_name", "奈乐").set("email", "23@");
        int result = userMapper.update(null, wrapper);
        System.out.println("result：" + result);
    }
    //使用lambda
    @Test
    public void updateWrapper2(){
        //将用户名中包含有 千 并且（年龄大于 20 或 邮箱为null）的用户信息修改
        //lambda可以直接访问 字段所对应的值，就可以防止写错数据库字段
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(User::getName, "千")
                .and(i -> i.gt(User::getAge, 20).or().isNull(User::getEmail));
        //修改为：
        wrapper.set(User::getName, "奈乐").set(User::getEmail, "23@");
        int result = userMapper.update(null, wrapper);
        System.out.println("result：" + result);
    }


    @Test
    public void selectNot1(){
        //模拟用户模糊查询
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //isNotBlank：判断某个字符是否不为空字符串，不为null，不为空白符
        if(StringUtils.isNotBlank(username)){
            wrapper.like("user_name", username);
        }
        if(ageBegin != null){
            wrapper.gt("age", ageBegin);
        }
        if(ageEnd != null){
            wrapper.le("age", ageEnd);
        }
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    //优化
    @Test
    public void selectNot2() {
        //模拟用户模糊查询
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //SELECT uid,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        //isNotBlank：判断某个字符是否不为空字符串，不为null，不为空白符
        wrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age",ageEnd);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    //使用lambda
    @Test
    public void selectNot3() {
        //模拟用户模糊查询
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        //lambda可以直接访问 字段所对应的值，就可以防止写错数据库字段
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }




}
