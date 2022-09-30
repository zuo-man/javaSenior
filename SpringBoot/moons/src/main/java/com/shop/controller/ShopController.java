package com.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.Shop;
import com.shop.pojo.User;
import com.shop.service.ShopService;
import com.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

@Api(tags = "商品")
@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation("根据ID查询商品")
    @GetMapping("/get/{id}")
    public Result getShopById(@PathVariable("id") Integer id){
        Shop byId = shopService.getById(id);

        return ReUtil.succ(byId);
    }

    @ApiOperation("增加商品")
    @PostMapping("save")
    public Result saveShop(@RequestBody Shop shop){

        String shopname = shop.getShopname();
        Double price = ( shop.getPrice() == null ) ? 100.00 : shop.getPrice();
        String type = ( shop.getType() == "" ) ? "word" : shop.getType();
        Integer stock = ( shop.getStock() == null ) ? 0 : shop.getStock();
        Integer isput = ( shop.getIsput() == null ) ? 1 : shop.getIsput();
        Integer istop = ( shop.getIsput() == null ) ? 1 : shop.getIsput();
        String origin = ( shop.getOrigin() == "" ) ? "word" : shop.getOrigin();
        Integer brandid = ( shop.getBrandid() == null ) ? 1 : shop.getBrandid();
        String pricture1 = ( shop.getPicture1() == "" ) ? "/wares/sw.jpg" : shop.getPicture1();
        String pricture2 = ( shop.getPicture2() == "" ) ? "/wares/sw.jpg" : shop.getPicture2();
        String pricture3 = ( shop.getPicture3() == "" ) ? "/wares/sw.jpg" : shop.getPicture3();

        shop = new Shop(null, shopname, pricture1, pricture2, pricture3, price, type, stock, isput, istop, origin, brandid, null,null);

        shopService.save(shop);

        return ReUtil.succ(shop);
    }



    @ApiOperation("更新商品")
    @PutMapping("/update")
    public Result updateShop(@RequestBody Shop shop){

        shop = new Shop(shop.getId(), shop.getShopname(), shop.getPicture1(), shop.getPicture2(), shop.getPicture3(),
                        shop.getPrice(), shop.getType(), shop.getStock(), shop.getIsput(), shop.getIstop(), shop.getOrigin(), shop.getBrandid(), null, null);

        shopService.updateById(shop);

        return ReUtil.succ(null);
    }




    @ApiOperation("根据 ids删除 一个或多个商品")
    @DeleteMapping("/remove/{ids}")
    public Result RemoveBatchShop(@PathVariable("ids") String[] ids){
        shopService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }



    @ApiOperation("模糊分页")
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

    @ApiOperation("unity查询所有商品")
    @GetMapping("/selectUnity")
    public Result selectUnity(){
        List unityShop = shopService.getUnityShop();

        return ReUtil.succ(unityShop);
    }

    @ApiOperation("上架商品")
    @GetMapping("/selectPut")
    public Result selectPut(){
        List put = shopService.getPut();

        return ReUtil.succ(put);
    }

    @ApiOperation("首页轮播图")
    @GetMapping("/selectTop")
    public Result selectTop(){
        List top = shopService.getTop();

        return ReUtil.succ(top);
    }




    //@ApiOperation("默认 用户分页  page：当前页码   limit：每页记录数")
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





