package com.ec.demo.cache.ErrorCache;

import com.ec.demo.annotation.ParamCheck;
import com.ec.demo.enums.CheckTypeEnum;
import lombok.Data;

@Data
public class ErrorEntry {
    @ParamCheck(type = CheckTypeEnum.CHECK_NULL_VALUE)
    private String errCodeId;


    private String errCode;
    private String errInf;
}
