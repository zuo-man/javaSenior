package com.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.Cart;
import com.shop.pojo.Orders;
import com.shop.pojo.Ordersfor;
import com.shop.pojo.Shop;
import com.shop.pojo.Vrshop;
import com.shop.service.CartService;
import com.shop.service.OrdersService;
import com.shop.service.OrdersforService;
import com.shop.service.ShopService;
import com.shop.service.UserService;
import com.shop.service.VrshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
* @author shengda
* @description cart CRUD操作
* @createDate 2022-05-23 22:54:22
*/

@Api(tags = "购物车")
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersforService ordersforService;
    @Autowired
    private VrshopService vrshopService;


    @ApiOperation("保存购物车信息")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public Result saveCart(@RequestBody HashMap<Object, Object> map){
        Integer uid = (Integer) map.get("uid");
        Integer sid = (Integer) map.get("sid");
        Integer sum = (Integer) map.get("sum");
        Integer judge = (Integer) map.get("judge"); //判断商品，0 商品，1 VR商品

        //获取当前时间
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create = data.format(new Date());

        //获取当前用户购物车信息
        Cart info = cartService.getByUidAndSid(uid, sid);

        //判断是普通商品 或是VR商品
        String shopName;
        Double price;
        Double total;
        String pricture;
        Integer stock;
        if (judge == 0){
            Shop shop= shopService.getById(sid);

            //商品
            shopName = shop.getShopname();
            price = shop.getPrice();
            pricture = shop.getPicture1();
            stock = shopService.getStockBySId(sid);//商品库存
        }else {
            Vrshop vrshop = vrshopService.getById(sid);

            //VR商品
            shopName = vrshop.getTitle();
            price = vrshop.getPrice();
            pricture = vrshop.getImgsrc();
            stock = vrshopService.getStockBySId(sid);//商品库存
        }

        //判断是否有库存
        if (sum > stock){

            return new Result(399, null, "商品：" + shopName
                    + " 库存不足，订单生成失败，此商品剩余库存为：" + stock, false);

        //数量为 0 ，删除此购物车商品
        }else if (sum == 0){

            cartService.removeById(info);

        //购物车没有此商品信息
        }else if(info == null){
            //总价
            total = price * sum;

            Cart cart = new Cart(null, uid, sid, shopName, pricture, price, total, sum, create);
            cartService.save(cart);

        //购物车有此商品信息
        }else {
            //修改总价
            total = price * sum;

            Integer cid = info.getCid();

            Cart cart = new Cart(cid, uid, sid, shopName, pricture, price, total, sum, create);
            cartService.updateById(cart);
        }

        return ReUtil.succ(null);
    }


    @ApiOperation("根据用户Uid 购物车生成订单")
    @PostMapping("/orders/{uid}")
    @Transactional(rollbackFor = Exception.class)
    public Result orders(@PathVariable("uid") Integer uid){

        //获取用户名、订单生成时间
        String username = userService.getById(uid).getUsername();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create = data.format(new Date());

        //随机生成订单ID
        Integer id = Integer.valueOf(ReUtil.getRandom());

        List<Cart> all = cartService.getByUidAll(uid);

        //总价格
        Double total = 0.00;
        //遍历购物车List集合
        for (Cart cart : all){
            total = total + cart.getTotal();

            Integer sum = cart.getSum();    //购买数量
            Integer sid = cart.getSid();    //商品ID

            Integer stock;
            String shopname = cart.getShopname();
            String picture = cart.getPricture();
            Double price = cart.getPrice();
            if ( sid <= 1000 ){
                stock = shopService.getStockBySId(sid);    //商品库存

                //更新库存
                shopService.updateStock(stock-sum, sid);

                //更新销量
                Integer sales = shopService.getSales(sid);
                shopService.updateSales(sales + sum, sid);
            }else {
                stock = vrshopService.getStockBySId(sid);

                //更新库存
                vrshopService.updateStock(stock-sum, sid);
            }

            //保存订单对应的商品列表
            Ordersfor ordersfor = new Ordersfor(id, sid, shopname, picture, price, sum);
            ordersforService.save(ordersfor);
        }

        //生成订单
        Orders orders = new Orders(id, uid, username, create, null, "未支付", total, null, null);
        ordersService.save(orders);

        //删除购物车数据
        cartService.deleteCart(uid);

        return ReUtil.succ(null);
    }



    @ApiOperation("查询用户购物车列表")
    @GetMapping("/selectPage/{page}/{limit}/{uid}")
    public Result selectCart( @PathVariable("page") Integer page,
                              @PathVariable("limit") Integer limit,
                              @PathVariable("uid") Integer uid ){

        Page<Cart> data = new Page<>(page, limit);

        cartService.getCartById(data, uid);

        return ReUtil.succ(data);
    }





}
