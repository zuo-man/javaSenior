package com.boot.controller;

import com.boot.bean.Class;
import com.boot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClassController {

    @Autowired
    ClassService classService;

    @ResponseBody
    @GetMapping("/classTest/{cId}")
    public Class classTest(@PathVariable("cId") Integer id){

        Class byId = classService.getById(1);
        return byId;
    }


}
