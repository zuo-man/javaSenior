package com.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){

        return new CommonResult(399, "自定义，handlerException");
    }

    public static CommonResult handlerException2(BlockException exception){

        return new CommonResult(399, "自定义，handlerException2");
    }

}
