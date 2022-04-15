package com.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName : 指定操作的数据库表
 *      若数据库表为 t_user 就写成 "t_user"
 */

//@TableName("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * @TableId : 将此属性所对应的字段 指定为主键id，驼峰命名也能对应
     *         value属性：用于指定主键的字段
     *         type属性：设置主键生成策略
     *                  默认是雪花算法生成id
     *                  AUTO，使用数据库自增策略生成id，确保数据库设置了id自增，否则无效
     *
     * 表中的类型是 bigint类型 ，范围大
     */
    @TableId(type = IdType.AUTO)      //也可以通过全局配置设置
    private Long uid;
    //也能写成这样
//    @TableId(value = "uid")
//    private Long id;  //id与数据库uid不一致，所以需要指定主键 "uid"

    /**
     * @TableField ： 指定普通属性所对应的字段名
     */
    @TableField("user_name")
    private String name;

    private SexEnum sex;

    private Integer age;

    private String email;

    /**
     * @TableLogic ：逻辑删除
     */
    @TableLogic
    private Integer isDeleted;

}
