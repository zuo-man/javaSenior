package com.shop.controller;

import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.mapper.ShopMapper;
import com.shop.service.OrdersService;
import com.shop.service.ShopService;
import com.shop.service.VrshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Api(tags = "图表")
@CrossOrigin
@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private VrshopService vrshopService;

    @ApiOperation("柱状图")
    @GetMapping("/shopSales")
    public Result shopSales(){
        List list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        //商品销量柱状图
        map.put("totalSales", shopService.sumSalesAll());          //总销量
        map.put("putshopTotal", shopService.putshopTotal());       //上架商品数
        map.put("putVrshopTotal", vrshopService.putVrshopTotal()); //上架VR商品数
        map.put("shopname", shopService.getShopNameAll());  //x轴，商品名
        map.put("sales", shopService.getSalesAll());        //y轴，销量




        //订单销售额柱状图
        map.put("salesTotal", ordersService.sumTotalAll()); //总销售额
        map.put("ordersAll", ordersService.ordersAll());    //订单总数
        map.put("payOrders", ordersService.payOrders());    //支付笔数
        //成交率（支付笔数/订单总数）
        String payRate;
        if(ordersService.ordersAll() == 0){
            payRate = "0.0%";
        }else {
            Float result = (float) ordersService.payOrders() / (float) ordersService.ordersAll();
            NumberFormat chage = NumberFormat.getPercentInstance();
            chage.setMaximumFractionDigits(1);//最多一位百分小数，如25.2%
            payRate = chage.format(result);
        }
        map.put("payRate", payRate);


        map.put("total", ordersService.getTotalAll());      //y轴，销售额
        List createAll = ordersService.getCreateAll();      //x轴，订单时间
        List create = new ArrayList();

        //Iterator迭代器，遍历Collection 集合中的元素。
        Iterator iterator = createAll.iterator();
        while (iterator.hasNext()){
            String next = String.valueOf(iterator.next());

            //substring：截取元素
            create.add(next.substring(11, 16));
        }
        map.put("create", create);  //x轴，订单时间



        list.add(map);
        return ReUtil.succ(list);
    }



}
