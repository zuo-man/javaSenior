package com.shop.controller;

import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.Descs;
import com.shop.pojo.Vrmode;
import com.shop.pojo.Vrshop;
import com.shop.service.DescsService;
import com.shop.service.VrshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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

import java.util.Arrays;
import java.util.List;

/**
* @author shengda
* @description VrShop CRUD操作
* @createDate 2022-05-19 15:22:45
*/
@Api(tags = "VR商品")
@CrossOrigin
@RestController
@RequestMapping("/vrshop")
public class VrShopController {

    @Autowired
    private VrshopService vrshopService;
    @Autowired
    private DescsService descsService;

    @ApiOperation("根据ID查询VR商品")
    @GetMapping("/get/{id}")
    public Result selectVrshopId(@PathVariable("id") Integer id){
        Vrshop vrshopAndDesc = vrshopService.getVrshopAndDesc(id);

        return ReUtil.succ(vrshopAndDesc);
    }


    @ApiOperation("新增VR商品")
    @PostMapping("/save")
    public Result saveVrshop(@RequestBody Vrshop vrshop){

        String title = vrshop.getTitle();
        String imgsrc = ( vrshop.getImgsrc() == "" ) ? "./imgs/bag.png" : vrshop.getImgsrc();
        Integer stock = ( vrshop.getStock() == null ) ? 100 : vrshop.getStock();
        Double price =  ( vrshop.getPrice() == null ) ? 100.00 : vrshop.getPrice();
        Integer isput = vrshop.getIsput();
        String modelPath = ( vrshop.getModelpath() == "" ) ? "./files/gltf/" : vrshop.getModelpath();
        String modelName = ( vrshop.getModelname() == "" ) ? "bag2.glb" : vrshop.getModelname();

        vrshop = new Vrshop(null, title, imgsrc, stock, price, isput, modelPath, modelName, null);
        vrshopService.save(vrshop);

        return ReUtil.succ(vrshop);
    }


    @ApiOperation("修改VR商品")
    @PutMapping("/update")
    public Result updateVrshop(@RequestBody Vrshop vrshop){

        vrshop = new Vrshop(vrshop.getId(), vrshop.getTitle(), vrshop.getImgsrc(), vrshop.getStock(),
                vrshop.getPrice(), vrshop.getIsput(), vrshop.getModelpath(), vrshop.getModelname(), null);
        vrshopService.updateById(vrshop);

        return ReUtil.succ(vrshop);
    }


    @ApiOperation("根据 ids删除 一个或多个VR商品")
    @DeleteMapping("/remove/{ids}")
    public Result deleteBatchRemoveVrShop(@PathVariable("ids") String[] ids){
        vrshopService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }


    @ApiOperation("查询上架VR商品")
    @GetMapping("/getPut")
    public Result selectVrshopPut(){
        List<Vrshop> vrshops = vrshopService.getVrshopPut();

        String[] all = new String[]{"000", "001", "002", "003", "004", "005"};

        return ReUtil.succ(new Vrmode(all, vrshops));
    }


    @ApiOperation("查询所有VR商品")
    @GetMapping("/getAll")
    public Result selectVrshopAll(){
        List<Vrshop> vrshops = vrshopService.getVrshopAll();

        String[] all = new String[]{"000", "001", "002", "003", "004", "005"};

        return ReUtil.succ(new Vrmode(all, vrshops));
    }



    //VR商品介绍

    @ApiOperation("根据VR商品ID查询所有介绍")
    @GetMapping("/getDescs/{vid}")
    public Result getDescById(@PathVariable("vid") Integer vid){

        return ReUtil.succ(descsService.getByVid(vid));
    }

    @ApiOperation("查询所有VR商品介绍")
    @GetMapping("/getDescsAll")
    public Result getDescsAll(){

        return ReUtil.succ(descsService.getDescsAll());
    }

    @ApiOperation("根据VR商品ID添加介绍")
    @PostMapping("/saveDescs")
    public Result saveDescsById(@RequestBody Descs descs){
        String title = ( descs.getTitle() == "" ) ?  "好" : descs.getTitle();
        String content = ( descs.getContent() == "" ) ? "非常好" : descs.getContent();

        descs = new Descs(null, descs.getVid(), title, content);

        descsService.save(descs);
        return ReUtil.succ(descs);
    }

    @ApiOperation("根据VR商品ID修改介绍，需要传入did,vid")
    @PutMapping("/updateDescs")
    public Result updateDescsById(@RequestBody Descs descs){
        descs = new Descs(descs.getDid(), descs.getVid(), descs.getTitle(), descs.getContent());

        descsService.updateById(descs);
        return ReUtil.succ(descs);
    }

    @ApiOperation("批量删除VR商品介绍")
    @DeleteMapping("/removeDescs/{dids}")
    public Result removeBatchDescs(@PathVariable("dids") String[] dids){
        descsService.removeBatchByIds(Arrays.asList(dids));

        return ReUtil.succ(null);
    }




}
