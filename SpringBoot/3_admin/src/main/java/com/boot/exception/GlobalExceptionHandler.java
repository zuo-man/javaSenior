package com.boot.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个MVC controller异常
 */

//@ControllerAdvice将当前类标识为异常处理的组件

@ControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})  //算术、空指针异常
    public String handleArithException(Exception ex, Model model){
        //ex表示当前请求处理中出现的异常对象，往请求域中传递异常数据
        model.addAttribute("message", ex);

        return "error/4xx"; //视图地址
    }
}
