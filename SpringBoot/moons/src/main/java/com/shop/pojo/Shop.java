package com.shop.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName shop
 */
@TableName(value ="shop")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shop implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    private String shopname;

    /**
     * 图片1
     */
    private String picture1;

    /**
     * 图片2
     */
    private String picture2;

    /**
     * 图片3
     */
    private String picture3;

    /**
     * 价格
     */
    private Double price;

    /**
     * 类别
     */
    private String type;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 是否上架  0,上架  1,下架
     */
    private Integer isput;

    /**
     * 首页轮播图  0,上  1,下
     */
    private Integer istop;

    /**
     * 产地
     */
    private String origin;

    /**
     * 对应品牌表的品牌 ID
     */
    private Integer brandid;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}