package com.boot.controller;

import com.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody ：用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
 */
//@ResponseBody
//@Controller

//将上面两个注解合为一个
@RestController

// JRebel：真正的热更新
@Slf4j  //lombok注解，日志
public class HelloContorller {

    @RequestMapping("/hello")
    public String hand_01(@RequestParam("name") String name){   //加了@RequestParam，进入hello页必须加name，否则进不去

        log.info("请求进来了。。。。");
        return "Hello, SpringBoot2" + name;
    }

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
