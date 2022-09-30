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
 * @TableName ordersfor
 */
@TableName(value ="ordersfor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ordersfor implements Serializable {

    private Integer oid;

    private Integer sid;

    private String shopname;

    private String picture;

    private Double price;

    private Integer osum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}