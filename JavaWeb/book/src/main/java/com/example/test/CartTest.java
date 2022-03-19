package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @create 2022-01-03 17:02
 */
public class CartTest {
    @Test
    public void addItem(){
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"无暇",1,new BigDecimal(22),new BigDecimal(22)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem(){
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"无暇",1,new BigDecimal(22),new BigDecimal(22)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear(){
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"无暇",1,new BigDecimal(22),new BigDecimal(22)));

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount(){
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"无暇",1,new BigDecimal(22),new BigDecimal(22)));

        cart.clear();

        cart.addItem(new CartItem(1,"小优",1,new BigDecimal(100),new BigDecimal(100)));
        cart.updateCount(1,10);

        System.out.println(cart);
    }
}
