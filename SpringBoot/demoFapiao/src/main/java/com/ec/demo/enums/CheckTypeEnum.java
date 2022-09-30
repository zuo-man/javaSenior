package com.ec.demo.enums;

public enum CheckTypeEnum {
    CHECK_NULL_VALUE("0","空值校验"),
    CHECK_PHONE_NUMBER("1","电话号码校验"),
    CHECK_POSTAL_CODE("2","邮政编码校验");

    private final String code;

    private final String desc;

    private CheckTypeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode(){return code;}

    public String getDesc(){return desc;}

}
