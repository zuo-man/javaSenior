package com.vod.exception;

import com.vod.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ExceptionHandler ：String中的异常处理器
 */

//AOP增强
@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody   //让错误信息返回成 Json数据
    public Result error(Exception e){
        e.printStackTrace();

        return Result.fail(null).message("执行全局异常处理");
    }

    //特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody   //让错误信息返回成 Json数据
    public Result error(ArithmeticException e){
        e.printStackTrace();

        return Result.fail(null).message("特定异常处理");
    }

    //自定义异常处理
    @ExceptionHandler(SlefException.class)
    @ResponseBody   //让错误信息返回成 Json数据
    public Result error(SlefException e){
        e.printStackTrace();

        return Result.fail(null).code(e.getCode()).message(e.getMsg());
    }

}
