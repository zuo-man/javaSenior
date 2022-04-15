package com.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.pojo.User;
import com.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        //分页查询数据    current:当前页码   size：每页显示几条数据
        Page<User> page = new Page<>(1, 2);
        //分页查询结果，  null为查询所有数据
                //若接口为 UserService，则分页方法为 userService.page

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //自定义分页，也可以在此处设定条件 Wrapper，取出的数据是一样的，但是，自定义分页会将逻辑删除的数据也一并输出
        //建议用默认分页page，设定分页条件wrapper就行
        //wrapper.gt("age", 20);
        //userMapper.selectPage(page, wrapper);

        userMapper.selectPage(page, null);
        System.out.println(page);

        System.out.println("当前页数据：" + page.getRecords());
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("有没有下一页：" + page.hasNext());
        System.out.println("有没有上一页：" + page.hasPrevious());
    }

    //测试自定义分页，以年龄 大于20排序， 但是，会将逻辑删除一并输出，除非添加形参限定
    @Test
    public void testPageManual(){
        //分页查询数据    current:当前页码   size：每页显示几条数据
        Page<User> page = new Page<>(1, 2);
        //select uid,user_name,age,email from t_user where age > ? LIMIT ?
        userMapper.selectPageVo(page, 20);

        System.out.println(page);
    }

}
