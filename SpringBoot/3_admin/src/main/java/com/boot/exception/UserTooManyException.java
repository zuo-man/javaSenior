package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常：用户太多异常，将会报403错误，表示资源不可用
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{

    //有参无参
    public UserTooManyException(){}
    public UserTooManyException(String message){
        super(message);
    }
}
