package com.vod.exception;

import com.vod.result.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//自定义异常类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlefException extends RuntimeException{

    private Integer code;
    private String msg;


}
