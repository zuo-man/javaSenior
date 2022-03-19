package com.example.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车对象
 * @create 2022-01-03 16:38
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    //key是商品编号，value是商品信息
    private Map<Integer, CartItem> itemList = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品项
     */
    public void addItem(CartItem cartItem){
        //查看购物车是否已经添加过此商品，已添加：数量添加，总金额更新。
        CartItem item = itemList.get(cartItem.getId());

        if(item == null){
            //没有添加过此商品
            itemList.put(cartItem.getId(), cartItem);
        }else {
            //已经添加过此商品
            item.setCount( item.getCount() + 1);// 数量累加
            //multiply：乘法、 更新总金额
            item.setTotalPrice( item.getPrice().multiply(new BigDecimal(item.getCount())) );
        }
    }
    /**
     * 删除商品项
     */
    public void deleteItem(Integer id){
        itemList.remove(id);
    }
    /**
     * 清空购物车
     */
    public void clear(){
        itemList.clear();
    }
    /**
     * 修改商品数量
     */
    public void updateCount(Integer id, Integer count){
        //先查看购物车中是否有此商品，有就修改商品数量，更新总金额
        CartItem cartItem = itemList.get(id);
        if(cartItem != null){
            cartItem.setCount(count);//修改商品数量
            //multiply：乘法、 更新总金额
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())) );
        }
    }


    public Integer getTotalCount() {
        //能使用局部变量，就不使用全局变量
        Integer totalCount = 0;

        for(Map.Entry<Integer, CartItem>entry : itemList.entrySet()){
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer, CartItem>entry : itemList.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }
    public Map<Integer, CartItem> getItemList() {
        return itemList;
    }
    public void setItemList(Map<Integer, CartItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", itemList=" + itemList +
                '}';
    }
}
