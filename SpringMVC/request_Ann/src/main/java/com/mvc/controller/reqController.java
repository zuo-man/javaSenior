package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @RequestMapping标识一个类： 设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法： 设置映射请求请求路径的具体信息
 */
@Controller
//@RequestMapping("/hello")
public class reqController {

    /**
     *  @RequestMapping： 请求映射注解，把当前请求和控制器方法创建映射关系，可以创建多个
     *  且一个项目中，@requestMapping注解value有且只能有一个匹配值
     */
    //method：此时表明，当前请求地址可以是/testRequestMapping，也可以是/test，但是！此时请求方式，必须为GET请求或者POST
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String suc(){
        return "success";
    }

    /**
     *  @RequestMapping 注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数
     * 和请求映射的匹配关系
     * "param"：要求请求映射所匹配的请求必须携带param请求参数
     * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
     * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
     * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
     */
    //params：此时表明，当亲请求参数必须携带username和password，且username的值一定不能是admin，且密码password必须为123
    @RequestMapping(
            value = {"/testPut"},
            method = {RequestMethod.PUT, RequestMethod.GET}
//           ,params = {"username!=admin","password=123"}
    )
    public String testPut(){
        return "success";
    }

    /**
     * @RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信
     * 息和请求映射的匹配关系
     * "header"：要求请求映射所匹配的请求必须携带header请求头信息
     * "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
     * "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
     * "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
     */
    @RequestMapping(
            value = {"/testHeadrs"},
            headers = {"Host=localhost:8080"}
    )
    public String testHeadrs(){
        return "success";
    }

    /**
     * SpringMVC支持路径中的占位符
     *      原始方式：/deleteUser?id=1
     *      rest方式：/deleteUser/1
     * SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服
     * 务器中，就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在
     * 通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
     */
//    @RequestMapping(value = "1?1/testAnt")    //？：表示任意的单个字符
    @RequestMapping(value = "1*1/testAnt")    //*：表示任意的0个或多个字符
//    @RequestMapping(value = "1**1/testAnt")  //**：表示任意的一层或多层目录，注意：在使用**时，只能使用/**/xxx的方式
    public String testAnt(){
        return "success";
    }
    @RequestMapping("testRest/{id}/{name}")
    public String testRest(@PathVariable("id")Integer id, @PathVariable("name")String name){
        System.out.println("传递的id为：" + id + "，name为：" + name);
        return "success";
    }


    /**
     * 对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解
     * 处理get请求的映射-->@GetMapping
     * 处理post请求的映射-->@PostMapping
     * 处理put请求的映射-->@PutMapping
     * 处理delete请求的映射-->@DeleteMapping
     */
    @GetMapping("/testGETMapping")
    public String testGET(){
        return "success";
    }

}
