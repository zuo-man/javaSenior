package com.java2;

/**
 * @create 2021-10-16 10:49
 */
public class Goods implements Comparable{
    private String name;
    private double price;


    //重写compareTo方法,指明按价格方式排序,若相等，按照产品名称排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;//判断o是否为商品，如果是商品，o进行强转
            //方法一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return -this.name.compareTo(goods.name);//不加-，从低到高，加-，从高到低
            }
            //方式二：
//            return Double.compare(this.price,goods.price);
    }
        throw new RuntimeException("传入的数据类型不一致");
    }




    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
