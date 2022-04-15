package com.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.Health;
import com.boot.service.HealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {

    @Autowired
    HealService healService;


    @ResponseBody
    @GetMapping("/healthPage")
    public Page<Health> healthPage(Model model){
        //分页查询数据    current:当前页码   size：每页显示几条数据
        Page<Health> pa = new Page<>(1,2);
        //分页查询结果，  null为查询所有数据
        Page<Health> page = healService.page(pa, null);

        model.addAttribute("page", page);

//        return "healthTest";
        return page;
    }


}
