package com.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.Shop;
import com.shop.pojo.User;
import com.shop.service.ShopService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
* @author shengda
* @description shop CRUD操作
* @createDate 2022-04-21 20:24:24
*/

@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/get/{id}")
    public Result getShopById(@PathVariable("id") Integer id){
        Shop byId = shopService.getById(id);

        return ReUtil.succ(byId);
    }

    //增加商品
    @PostMapping("save")
    public Result saveShop(@RequestBody HashMap<Object, String> map){

        String shopname = map.get("shopname");
        Double price = Double.valueOf(( map.get("price") == "" ) ? "100.00" : map.get("price"));
        String type = map.get("type");                                                           //类型
        Integer stock = Integer.valueOf(( map.get("stock") == "" ) ? "0" : map.get("stock"));    //库存
        Integer isput = Integer.valueOf(( map.get("isput") == "" ) ? "1" : map.get("isput"));     //是否上架，默认 1不上架
        String origin = ( map.get("origin") == "" ) ? "world" : map.get("origin");               //生产地
        Integer brandid = Integer.valueOf(( map.get("brandid") == "") ? "1" : map.get("brandid"));   //对应品牌表 id
        String picture1 = ( map.get("picture1") == "" ) ? "/wares/sw.jpg" : map.get("picture1");
        String picture2 = ( map.get("picture2") == "" ) ? "/wares/sw.jpg" : map.get("picture2");
        String picture3 = ( map.get("picture3") == "" ) ? "/wares/sw.jpg" : map.get("picture3");

        Shop shop = new Shop(null, shopname, picture1, picture2, picture3, price, type, stock, isput, origin, brandid, null);
        shopService.save(shop);

        return ReUtil.succ(shop);
    }



    //更新商品
    @PutMapping("/update")
    public Result updateShop(@RequestBody HashMap<Object, String> map){

        Integer id = Integer.valueOf(map.get("id"));
        String shopname = map.get("shopname");
        Double price = Double.valueOf(map.get("price"));
        String type = map.get("type");                                                           //类型
        Integer stock = Integer.valueOf(map.get("stock"));    //库存
        Integer isput = Integer.valueOf(map.get("isput"));     //是否上架，默认 1不上架
        String origin = map.get("origin");               //生产地
        Integer brandid = Integer.valueOf(map.get("brandid"));   //对应品牌表 id
        String picture1 = map.get("picture1");
        String picture2 =  map.get("picture2");
        String picture3 =  map.get("picture3");

        Shop shop = new Shop(id, shopname, picture1, picture2, picture3, price, type, stock, isput, origin, brandid, null);
        shopService.updateById(shop);

        return ReUtil.succ(null);
    }




    //根据 ids删除 一个或多个商品
    @DeleteMapping("/remove/{ids}")
    public Result deleteBatchRemoveShop(@PathVariable("ids") String[] ids){
        shopService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }



    //分页
    @PostMapping("/selectPage/{page}/{limit}")
    public Result selectPageShop(
                        @PathVariable("page") Integer page,
                        @PathVariable("limit") Integer limit,
                        @RequestBody HashMap<Object, String> map){

        String shopname = map.get("shopname");
        String type = map.get("type");
        String origin = map.get("origin");
        String brandname = map.get("brandname");
        String isput = map.get("isput");

        String sort = ( map.get("sort") == "" ) ? "desc" : map.get("sort");


        Page<Shop> data = new Page<>(page, limit);

        shopService.pageShop(data, shopname, type, origin, brandname, isput, sort);

        return ReUtil.succ(data);
    }

    //上架商品
    @GetMapping("/selectPut")
    public Result selectPut(){
        List put = shopService.getPut();

        return ReUtil.succ(put);
    }




    //默认 用户分页  page：当前页码   limit：每页记录数
//    @GetMapping("/{page}/{limit}")
//    public Result getShopPage(@PathVariable("page") Integer page,
//                              @PathVariable("limit") Integer limit){
//
//        //分页查询数据    current:当前页码   size：每页显示几条数据
//        Page<Shop> shopPage = new Page<>(page, limit);
//        //分页查询结果，  null为查询所有数据
//        shopService.page(shopPage, null);
//
//        return ReUtil.succ(shopPage);
//    }





}





