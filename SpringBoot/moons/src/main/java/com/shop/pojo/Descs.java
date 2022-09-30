package com.shop.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName descs
 */
@TableName(value ="descs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Descs implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer did;

    /**
     * 对应VR商品ID
     */
    private Integer vid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}