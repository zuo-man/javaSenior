package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    /*
    请求转发：
    当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视
    图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部
    分作为最终路径通过转发的方式实现跳转
     */
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    /*
    重定向：
    当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时的视图名称不
    会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，剩余部分作为最
    终路径通过重定向的方式实现跳转
    例如"redirect:/"，"redirect:/employee"
     */
    @RequestMapping("testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

}
