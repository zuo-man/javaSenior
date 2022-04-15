package com.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data

public class Product {

    private Long id;

    private String name;

    private Integer price;

    /**
     * @Verson ：标识乐观锁版本号字段
     */
    @Version
    private Integer version;

}
