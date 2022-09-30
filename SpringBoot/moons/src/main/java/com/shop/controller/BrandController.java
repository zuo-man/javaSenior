package com.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.Brand;
import com.shop.pojo.Shop;
import com.shop.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import java.util.Map;

/**
* @author shengda
* @description shop CRUD操作
* @createDate 2022-04-28 15:34:22
*/

@Api(tags = "品牌")
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @ApiOperation("根据品牌ID查询")
    @GetMapping("/get/{id}")
    public Result getBrandById(@PathVariable("id") Integer id){
        Brand byId = brandService.getById(id);

        return ReUtil.succ(byId);
    }


    @ApiOperation("保存品牌")
    @PostMapping("/save")
    public Result saveBrand(@RequestBody Brand brand) throws IOException{
        String brandname = brand.getBrandname();

        if(brandService.getBrandName(brandname) != null){

            return new Result(399, null, "品牌名已存在", false);
        }else{

            //三元运算，若为空，则使用默认值
            String site = ( brand.getSite() == "" ) ? "World" : brand.getSite();
            String introduce = ( brand.getIntroduce() == "" ) ? "无介绍" : brand.getIntroduce();
            String logo = ( brand.getLogo() == "" ) ? "/brand/tu.jpg" : brand.getLogo(); //上传的文件为空，使用默认logo

            brand = new Brand(null, brandname, logo, site, introduce, null);

            brandService.save(brand);

            return ReUtil.succ(brand);
        }
    }


    @ApiOperation("更新品牌")
    @PutMapping("/update")
    public Result updateBrand(@RequestBody Brand brand){

        brand = new Brand(brand.getId(), brand.getBrandname(), brand.getLogo(),
                          brand.getSite(), brand.getIntroduce(), null);

        brandService.updateById(brand);

        return ReUtil.succ(null);
    }


    @ApiOperation("根据 ids删除 一个或多个品牌")
    @DeleteMapping("/remove/{ids}")
    public Result RemoveBatchBrand(@PathVariable("ids") String[] ids){
        brandService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }

    @ApiOperation("获取 Brand 全部List集合信息")
    @GetMapping("/getAll")
    public Result getAllBrand(){
        List<Brand> list = brandService.list(null);

        return ReUtil.succ(list);
    }



    @ApiOperation("默认 品牌分页  page：当前页码   limit：每页记录数")
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
