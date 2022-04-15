package com.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//指定操作的数据表
@TableName("t_user")
public class TUser {

    //数据库t_user

//    @TableField(exist=false)：表示当前属性不是数据库的字段
    private Integer id;

    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;
}
