package com.shop.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName vrshop
 */
@TableName(value ="vrshop")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vrshop implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片路径
     */
    private String imgsrc;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 价格
     */
    private Double price;

    /**
     * 是否上架
     */
    private Integer isput;

    /**
     * 模型路径
     */
    private String modelpath;

    /**
     * 模型名称
     */
    private String modelname;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;


    //一对多，对应集合
    private List<Descs> descs;


    public Vrshop(Integer id, String title, String imgsrc, Integer stock, Double price, Integer isput, String modelpath, String modelname, Integer deleted) {
        this.id = id;
        this.title = title;
        this.imgsrc = imgsrc;
        this.stock = stock;
        this.price = price;
        this.isput = isput;
        this.modelpath = modelpath;
        this.modelname = modelname;
        this.deleted = deleted;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}