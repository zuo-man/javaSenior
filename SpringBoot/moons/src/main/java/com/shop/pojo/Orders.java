package com.shop.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 对应用户ID
     */
    private Integer uid;

    /**
     * 对应用户名
     */
    private String user;

    /**
     * 创建订单时间
     */
    private String createtime;

    /**
     * 支付时间
     */
    private String paytime;

    /**
     * 支付状态
     */
    private String state;

    /**
     * 总价
     */
    private Double total;

    /**
     * 交易号
     */
    private String payNo;

    /**
     * 是否线下取货，0是 ， 1否
     */
    private Integer isdown;

    //一对多，对应集合
    private List<Ordersfor> ordersfor;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Orders(Integer id, Integer uid, String user, String createtime, String paytime, String state, Double total, String payNo, Integer isdown) {
        this.id = id;
        this.uid = uid;
        this.user = user;
        this.createtime = createtime;
        this.paytime = paytime;
        this.state = state;
        this.total = total;
        this.payNo = payNo;
        this.isdown = isdown;
    }
}