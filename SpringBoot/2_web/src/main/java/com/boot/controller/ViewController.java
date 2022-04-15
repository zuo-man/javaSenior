package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    //配置文件yml中设置了 服务器前置路径，之后的所有请求必须以/world开始  http://localhost:8080/world/hello
    @RequestMapping("/hello")
    public String hello(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a", aa)
        model.addAttribute("hello", "/hello请求视图跳转 success ");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";
    }
}
