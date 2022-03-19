package com.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//基于注解处理异常
//@ControllerAdvice将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    /**
     * @ExceptionHandler ：用于设置所标识方法处理的异常
     *  此时当出现，算术异常、空指针异常，就会在新的控制器方法执行跳转
     */
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testExctption(Exception ex, Model model){
        //ex表示当前请求处理中出现的异常对象，往请求域中传递异常数据
        model.addAttribute("ext", ex);
        return "error";
    }

}
