package com.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.pojo.Change;
import com.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class userTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void userById(){
//        User user = userMapper.selectById(1);
//        System.out.println(user);
        User byId = userService.getById(1);
        System.out.println(byId);
    }

    @Test
    public void userAll(){
        Map<String, Object> map = userService.getMap(null);
        System.out.println(map);
    }

    @Test
    public void usernameAndPassword(){
//        User user1 = userMapper.selectByUsernameAndByPassword("小优", "123");
//        System.out.println(user1);

        User user = userService.loginByUsernameAndByPassword("小优", "123");
        System.out.println(user);
        System.out.println(user.getId());
    }

    @Test
    public void select1(){
        //模拟用户模糊查询
        String username = "小优";
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //SELECT uid,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        //isNotBlank：判断某个字符是否不为空字符串，不为null，不为空白符

        // 查询中，deleted添加了 @TableLogin字段，逻辑删除为1的不查询
        wrapper.like(StringUtils.isNotBlank(username), "username", username);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    @Test
    public void Lujing(){
        String property = System.getProperty("user.dir");

        System.out.println(property);

        File f = new File(this.getClass().getResource("/").getPath());

        System.out.println(f);


        URL xmlpath = this.getClass().getClassLoader().getResource("static/imps");

        System.out.println(xmlpath);


        // 输出：D:\MyCode\log\log4j2-java
        System.out.println(System.getProperty("user.dir"));


        File savePos = new File(System.getProperty("user.dir") + "/src/main/resources/static/imps");
        System.out.println(savePos);
    }


    @Test
    public void date(){
        //2022-04-19 10:26:41
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));

    }

    @Test
    public void token1(){
        redisTemplate.opsForValue().set("t4", "小优", Duration.ofMinutes(3L));
        Object t4 = redisTemplate.opsForValue().get("t4");
        Object t3 = redisTemplate.opsForValue().get("38bb14d50-cf7a-4108-94b4-faefd5fc5afb");

        System.out.println(t3);
        System.out.println(t4);
    }

    @Test
    public void tokenLogout(){
        redisTemplate.delete("3f43ce80e-9d1e-4863-9e06-9018ef990db4");
    }


    //删除多个User
    @Test
    public void BatchUser(){

        String[] arr = new String[]{"4","5"};
        System.out.println(Arrays.toString(arr));

//        List<int[]> ints = Arrays.asList(arr);
        ArrayList a = new ArrayList();

        List l = new ArrayList();
        l.add("4");
        l.add(5);
        //根据 id批量删除
        //Arrays.asList：数组转化成List集合
//        List<Long> list = Arrays.asList(5L, 6L);
//        int result1 = userMapper.deleteBatchIds(list);

        boolean b = userService.removeBatchByIds(Arrays.asList(arr));
    }

    @Test
    public void role(){
        User user = userService.getById(1);

        Change ad = new Change();

        ad.setId(user.getId());
        ad.setUsername(user.getUsername());
        ad.setPassword(user.getPassword());

        String roleName = user.getRoleName();

        String[] role = new String[1];
        role[0] = roleName;

        ad.setRoleName(role);

        System.out.println(ad.getRoleName());


        System.out.println(ad);



    }



    //模糊查询 用户 角色
    @Test
    public void selectUsernameAndRole(){
//        List<User> user1 = userMapper.selectByUsernameOrByRoleName("", "");
//        List<User> user2 = userMapper.selectByUsernameOrByRoleName("12", "");
//        List<User> user3 = userMapper.selectByUsernameOrByRoleName("","用户");
//        List<User> user4 = userMapper.selectByUsernameOrByRoleName("12","用户");
//        List<User> user5 = userMapper.selectByUsernameOrByRoleName("admin", "管理员");
//
//        user1.forEach(System.out::println);
//        System.out.println("****");
//        user2.forEach(System.out::println);
//        System.out.println("****");
//        user3.forEach(System.out::println);
//        System.out.println("****");
//        user4.forEach(System.out::println);
//        System.out.println("****");
//        user5.forEach(System.out::println);
    }



}
