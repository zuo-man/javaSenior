package com.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {

    MALE(1, "男"),
    FEMALE(0, "女");

    /**
     * @EumValue ：将注解所标识的属性的值存储到数据库中
     */
    @EnumValue
    private Integer sex;

    private String sexName;

    //私化类的构造器,并给对象属性赋值
    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
