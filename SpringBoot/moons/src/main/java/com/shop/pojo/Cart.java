package com.shop.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName cart
 */
@TableName(value ="cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart implements Serializable {
    /**
     * 购物车ID
     */
    @TableId(type = IdType.AUTO)
    private Integer cid;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 商品ID
     */
    private Integer sid;

    /**
     * 商品名称
     */
    private String shopname;

    /**
     * 图片
     */
    private String pricture;

    /**
     * 单价
     */
    private Double price;

    /**
     * 总价
     */
    private Double total;

    /**
     * 商品数量
     */
    @TableField("`sum`")
    private Integer sum;

    /**
     * 创建时间
     */
    @TableField("`create`")
    private String create;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}