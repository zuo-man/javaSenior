package com.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_tbl")
public class Order {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;
}
