package com.boot.controller;

import com.boot.bean.College;
import com.boot.mapper.CollegeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
public class CollegeController {

    @Autowired
    private CollegeMapper collegeMapper;

    @GetMapping("/getAllCollege")
    public List<Map<String, Object>> getAllCollege(){

//        College college = collegeMapper.selectById(1);
        List<Map<String, Object>> maps = collegeMapper.selectMaps(null);

        return maps;
    }


    @PostMapping("/insertCollege")
    public String insertCollege(@RequestParam("name") String name){
        College college = new College(null, name);
        collegeMapper.insert(college);

        return "插入成功";
    }





}
