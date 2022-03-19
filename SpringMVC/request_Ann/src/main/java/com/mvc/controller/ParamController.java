package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.Arrays;

//测试请求参数
@Controller
public class ParamController {

    @RequestMapping("/testParam")
    /**
     * 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串
     * 数组或者字符串类型的形参接收此请求参数
     * 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
     * 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
     */
//    public String testParam(String username, String password, String hobby){    //输出用，隔开
//        System.out.println("username" + username + "，passowrd=" + password + "，爱好：" + hobby);
//        return "success";
//    }
    //或者
    /**
     * @RequestParam是将请求参数和控制器方法的形参创建映射关系，有三个属性
     * value：指定为形参赋值的请求参数的参数名
     * required：设置是否必须传输此请求参数，默认值为true
     *      若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置
     *      defaultValue（默认值）属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为
     *      false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
     * defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
     *      为""时，则使用默认值为形参赋值
     */
    public String testParam(@RequestParam(value = "user__name", required = false) String username,//此时表示user__nane的值可以不传输，且默认值就是true，设置为true时，user__name'的值必须传输
                            @RequestParam(defaultValue = "hehe") String password,   //没有传输值时，用默认值hehe
                            String[] hobby,
                            @CookieValue("JSESSIONID") String JSESSIONID){    //输出数组
        System.out.println("username" + username + "，passowrd=" + password + "，爱好：" + Arrays.toString(hobby));
        System.out.println("JSEEIONID的值：" + JSESSIONID);
        return "success";
    }
    /*
    @CookieValue是将cookie数据和控制器方法的形参创建映射关系
    @CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
     */

    /*
    @RequestHeader是将请求头信息和控制器方法的形参创建映射关系
    @RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
     */
    @RequestMapping("/testHeader")
    public String testHeader(
            @RequestHeader(value = "host", required = false, defaultValue = "8181") String host){
        System.out.println("host" + host);
        return "success";
    }

    /*
    在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实
    体类中的属性名一致，那么请求参数就会为此属性赋值
     */
    @RequestMapping("/testBean") 
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }



    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求，前端控制器DispatcherServlet会间接的把传递过来的值赋给方法形参中
    public String testServletAPI(HttpServletRequest request){
        //创建Cookie
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username" + username + "，passowrd=" + password);
        return "success";
    }
}
