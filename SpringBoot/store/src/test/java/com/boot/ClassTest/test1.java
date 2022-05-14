package com.boot.ClassTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.Class;
import com.boot.bean.College;
import com.boot.bean.Health;
import com.boot.mapper.CollegeMapper;
import com.boot.service.ClassService;
import com.boot.service.HealService;
import com.boot.service.Impl.ClassServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class test1 {

    @Autowired
    ClassService classService;

    @Autowired
    HealService healService;


    @Test
    public void getClassById(){

//        Class classById = classService.getClassById(1);
//        System.out.println(classById);

    }

    @Test
    public void test1(){
//        Class aClass = new Class(3, "1");
//        classService.save(aClass);

        Class byId = classService.getById(1);

        System.out.println(byId);

    }


    @Test
    public void test2(){

        //分页查询数据    current:当前页码   size：每页显示几条数据

        //分页查询结果，  null为查询所有数据




        Page<Health> page = new Page<>(1,2);
        Page<Health> page1 = healService.page(page, null);

        System.out.println(page1);
    }

    @Autowired
    private CollegeMapper collegeMapper;


    @Test
    public List<College> getAllCollege(){

        List<College> colleges = collegeMapper.selectList(null);

        return colleges;
    }

}
