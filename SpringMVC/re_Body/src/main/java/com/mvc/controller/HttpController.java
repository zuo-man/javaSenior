package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @RestController： 注解是springMVC提供的一个复合注解，标识在控制器的类上，就相当于为类添加了
 * @Controller 注解，并且为其中的每个方法添加了@ResponseBody注解
 */

@Controller
public class HttpController {

    /**
     * @RequestBody ：将请求报文转换为Java对象
     * 可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，当
     * 前请求的请求体就会为当前注解所标识的形参赋值
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody：" + requestBody);
        return "success";
    }

    /**
     * 封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的
     * 请求报文就会赋值给该形参，可以通过getHeaders()获取请求头信息，通过getBody()获取具体的请求体信息
     */
    @RequestMapping("/testRequestEntiey")
    public String testRequestEntiey(RequestEntity<String> requestEntity){
        //当前requestEnity表示整个请求报文的信息
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    /**
     * @ResponseBody ：用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
     */
    @RequestMapping("testResponseBody")
    @ResponseBody
    public User testResponseBody(){
        return new User(1,"小优","234");
    }


    /**
     * SpringMVC处理ajax
     */
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        System.out.println("用户名：" + username + "，密码：" + password);
        return "hello, axios";
    }




    //通过源生API HttpServletResponse响应浏览器数据
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException{
        response.getWriter().println("hello, HttpServletResponse");
    }


}
