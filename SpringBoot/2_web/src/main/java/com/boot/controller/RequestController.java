package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){

        request.setAttribute("req1","请求数据 一 ");
        request.setAttribute("code", 222);
        return "forward:/success";  //转发到  /success请求
    }


    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        //用map 集合 存储数据
        map.put("http_1","http 请求");
        //用 model 模型     往前台传数据，可以传对象，可以传List
        model.addAttribute("world"," 世界 ");
        //用request 请求  设置session
        request.setAttribute("message","HelloWorld");

        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/success";
    }


    @ResponseBody //@RequestBody（获取请求体[POST]）
                 //@RequestAttribute（获取request域属性）
                // @RequestAttribut 属性有参数值时，表明传递过来的request必须携带req1和code属性，否则报缺少请求属性错误
                                    //若该属性可以不被需要，可以加requered=false，request域中就不必须加
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "req1", required = false) String req1,
                       @RequestAttribute(value = "code", required = false) Integer code,
                       HttpServletRequest request){
        Object R1 = request.getAttribute("req1");
        Object R2 = request.getAttribute("code");

        Map<String,Object> map = new HashMap<>();
        Object hello = request.getAttribute("http_1");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("reqMethod_msg",R1);
        map.put("annotation_msg",R2);


        map.put("http_1",hello);
        map.put("world",world);
        map.put("message",message);

        return map;

    }
}
