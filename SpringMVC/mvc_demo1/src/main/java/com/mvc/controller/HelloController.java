package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC的控制器由一个POJO（普通的Java类）担任，因此需要通过@Controller注解将其标识
 * 为一个控制层组件，交给Spring的IoC容器管理，此时SpringMVC才能够识别控制器的存在
 */

@Controller
public class HelloController {

    /**
     *  @RequestMapping： 请求映射注解，把当前请求和控制器方法创建映射关系
     *  当前浏览器发送的请求是 "/" 时，就会执行标识的方法
     *  "/"--> /WEB-INF/templates/index.html
     */
    @RequestMapping("/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}
