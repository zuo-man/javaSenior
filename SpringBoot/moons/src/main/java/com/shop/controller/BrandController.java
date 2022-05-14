package com.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.Brand;
import com.shop.pojo.Shop;
import com.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
* @author shengda
* @description shop CRUD操作
* @createDate 2022-04-28 15:34:22
*/

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @GetMapping("/get/{id}")
    public Result getBrandById(@PathVariable("id") Integer id){
        Brand byId = brandService.getById(id);

        return ReUtil.succ(byId);
    }


    @PostMapping("/save")
    public Result saveBrand(@RequestBody HashMap<Object, String> map) throws IOException{

        String brandname =  map.get("brandname");

        if(brandService.getBrandName(brandname) != null){

            return new Result(399, null, "品牌名已存在", false);
        }else{

            //三元运算，若为空，则使用默认值
            String site =       ( map.get("site") == "" ) ? "World" : map.get("site");
            String introduce =  ( map.get("introduce") == "" ) ? "无介绍" : map.get("introduce");

            String logo = ( map.get("logo") == "" ) ? "/brand/tu.jpg" : map.get("logo");//上传的文件为空，使用默认logo

            Brand brand = new Brand(null, brandname, logo, site, introduce, null);
            brandService.save(brand);

            return ReUtil.succ(brand);
        }
    }


    @PutMapping("/update")
    public Result updateBrand(@RequestBody HashMap<Object, String> map){

        Integer id = Integer.valueOf(map.get("id"));
        String brandname = map.get("brandname");
        String logo = map.get("logo");
        String site = map.get("site");
        String introduce = map.get("introduce");

        Brand brand = new Brand(id, brandname, logo, site, introduce, null);

        brandService.updateById(brand);

        return ReUtil.succ(null);
    }


    //根据 ids删除 一个或多个品牌
    @DeleteMapping("/remove/{ids}")
    public Result deleteBatchRemoveBrand(@PathVariable("ids") String[] ids){
        brandService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }

    //获取 Brand 全部List集合信息
    @GetMapping("/getAll")
    public Result getAllBrand(){
        List<Brand> list = brandService.list(null);

        return ReUtil.succ(list);
    }



    //默认 品牌分页  page：当前页码   limit：每页记录数
    @GetMapping("/{page}/{limit}")
    public Result getBrandPage(@PathVariable("page") Integer page,
                              @PathVariable("limit") Integer limit){

        //分页查询数据    current:当前页码   size：每页显示几条数据
        Page<Brand> brandPage = new Page<>(page, limit);
        //分页查询结果，  null为查询所有数据
        brandService.page(brandPage, null);

        return ReUtil.succ(brandPage);
    }






}
