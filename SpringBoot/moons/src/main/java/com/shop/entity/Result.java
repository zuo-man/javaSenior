package com.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//全局返回结果对象

@Component
public class Result {

    //状态码
    private Integer code;

    private String token;

    //数据
    private Object data;

    //跳转信息
    private String message;

    private boolean success;

    //除 token之外的构造器
    public Result(Integer code, Object data, String message, boolean success) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = success;
    }

}
