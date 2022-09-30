package com.shop.controller;

import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.entity.SFtpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author shengda
 * @description 文件上传
 * @createDate 2022-04-24 12:31:41
 */

@Api(tags = "文件上传")
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    @ApiOperation("用户头像上传接口")
    @PostMapping("/fileUser")
    public Result FileUpload(@RequestBody MultipartFile salt) throws Exception{
        //用户 User头像路径
        String route = "/imps/";

        String dataRoute = FileCloudUp(salt, route);

        return ReUtil.succ(dataRoute);
    }

    @ApiOperation("商品图片上传接口")
    @PostMapping("/fileShop")
    public Result FileShop(@RequestBody MultipartFile picture) throws Exception{
        //商品 Shop图片路径
        String route = "/wares/";

        String dataRoute = FileCloudUp(picture, route);

        return ReUtil.succ(dataRoute);
    }

    @ApiOperation("品牌logo上传接口")
    @PostMapping("/fileBrand")
    public Result FileBrand(@RequestBody MultipartFile logo) throws Exception{
        //品牌 Brandlogo路径
        String route = "/brand/";

        String dataRoute = FileCloudUp(logo, route);

        return ReUtil.succ(dataRoute);
    }

    //文件上传至 服务器工具方法
    private String FileCloudUp(MultipartFile pho, String path)throws Exception{

        //获取文件名
        String originalFileName = pho.getOriginalFilename();
        //处理文件重名问题
        String hzname = originalFileName.substring(originalFileName.lastIndexOf(".")); //获取文件名最后一个 . 之后的文件名
        originalFileName = UUID.randomUUID() + hzname;

        //上传数据库相对路径
        String dataRoute = path + originalFileName;

        //上传图像到服务器          getInputStream：获取文件源生的流
        SFtpUtil sftp = new SFtpUtil();
        //http://47.96.175.143:80/usr/local/nginx/html
        sftp.uploadFile(originalFileName, pho.getInputStream(), path);

        return dataRoute;
    }



    //文件上传本地工具方法
    private String FileUp(MultipartFile salt, String path)throws Exception{
        //获取项目路径
        String route = System.getProperty("user.dir") + "/moons/src/main/resources/static" + path;

        //获取文件名
        String originalFileName = salt.getOriginalFilename();
        //处理文件重名问题
        String hzname = originalFileName.substring(originalFileName.lastIndexOf(".")); //获取文件名最后一个 . 之后的文件名
        originalFileName = UUID.randomUUID() + hzname;

        //图片路径
        String fileRoute = route + originalFileName;

        //上传数据库相对路径
        String dataRoute = path + originalFileName;

        //上传头像到本地
        salt.transferTo(new File(fileRoute));

        return dataRoute;
    }


}
