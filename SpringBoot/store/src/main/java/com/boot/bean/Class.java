package com.boot.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


//指定操作的数据表
//@TableName("class")
public class Class {

    /**
     * @TableId : 将此属性所对应的字段 指定为主键id
     */
    @TableId
    private Integer cId;
    private String classes;
}
