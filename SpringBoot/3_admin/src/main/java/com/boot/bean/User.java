package com.boot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;
    private String password;


    //@TableFied(exist=false)：表示以下字段在数据库中不存在
//    private String id;
}
