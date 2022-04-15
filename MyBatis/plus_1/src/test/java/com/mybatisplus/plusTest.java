package com.mybatisplus;

import com.mybatisplus.enums.SexEnum;
import com.mybatisplus.mapper.ProductMapper;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.pojo.Product;
import com.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class plusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testSelectList(){

        //wrapper 查询条件，null表示没有条件，查全部
        List<User> list = userMapper.selectList(null);

        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "小优", SexEnum.FEMALE, 22, "123",0);
        userMapper.insert(user);

        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        System.out.println("id：" + user.getUid());
    }

    @Test
    public void testDelete(){
        //根据 Map集合设置 特定条件删除数据
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("age", 14);
//        int result = userMapper.deleteByMap(map);

        //根据 id批量删除
        //Arrays.asList：数组转化成List集合
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result1 = userMapper.deleteBatchIds(list);
        System.out.println(result1);
    }

    @Test
    public void testUpdate(){
        User user = new User(5L, "小优", SexEnum.FEMALE, null, "123",null);
        //当其中一个字段 没有设置值，也就是空的时候，会把原来的值 写入，也就是该字段不做修改

        //UPDATE user SET name=?, email=? WHERE id=?
        int result = userMapper.updateById(user);
    }


    @Test
    public void testSelect(){
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

        //根据多个 id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN (?,?,?)
//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        List<User> users = userMapper.selectBatchIds(list);
//        users.forEach(System.out::println);

        //根据 Map集合设置 特定条件查询数据
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "小优");
        map.put("age", 21);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试自定义查询方法
    @Test
    public void testSe(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

    //乐观锁测试
    @Test
    public void testProduct1(){
        //小李取数据
        Product p1 = productMapper.selectById(1L);
        //小王取数据
        Product p2 = productMapper.selectById(1L);
        //小李修改 + 50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改的结果：" + result1);
        //小王修改 - 30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改的结果：" + result2);
        if(result2 == 0){
        //失败重试，重新获取version并更新
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
        }
        System.out.println("小王修改重试的结果：" + result2);
        //老板看价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板看价格：" + p3.getPrice());

    }


}
