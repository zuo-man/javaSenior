package com.example.pojo;

import java.math.BigDecimal;

/**
 * @create 2021-12-23 11:18
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
                            //在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算
    private BigDecimal price;//赋值之后2个小数
    private Integer sales;//销量
    private Integer stock;//库存
    private String imgPath = "static/img/dew.jpg";//图片默认地址

    public Book() {
    }
    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;

        //要求给定的图书封面路径不能为空
        //如果传入的imgPath为空，则使用前面赋值的默认路径，传入的imgPath不为空且不是空字符串，则进行新的图片赋值
        if(imgPath != null && !"".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        //要求给定的图书封面路径不能为空
        //如果传入的imgPath为空，则使用前面赋值的默认路径，传入的imgPath不为空且不是空字符串，则进行新的图片赋值
        if(imgPath != null && !"".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
