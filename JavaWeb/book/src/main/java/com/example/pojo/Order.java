package com.example.pojo;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.Date;

/**
 * @create 2022-01-04 19:49
 */
public class Order {
    private String orderId;  //订单号
    private Date createTime;  //下单时间
    private BigDecimal price;     //金额
    // 0 表示未发货、1 已发货、 2已签收
    private Integer status = 0;
    private Integer userId;   //用户Id，和User表外键绑定

    public Order() {
    }
    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
