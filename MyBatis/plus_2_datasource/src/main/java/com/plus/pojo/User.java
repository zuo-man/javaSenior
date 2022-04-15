package com.plus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer uid;

    private String userName;

    private Integer sex;

    private Integer age;

    private String email;

    private Integer isDeleted;

}
