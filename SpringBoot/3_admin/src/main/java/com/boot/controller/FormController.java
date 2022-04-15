package com.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     *  文件上传
     *  MultipartFile：自动封装上传过来的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos)         throws IOException {

//        log.info("上传的信息：email={}, username={}, headerImg={}, photos={},",
//                email, username, headerImg.getSize(), photos.length);

        //判断上传的文件是否为空
        if(!headerImg.isEmpty()){
            //保存到文件服务器，OSS服务器
            //获取文件名
            String originalFilename = headerImg.getOriginalFilename();
            //处理文件重名问题
            String hzName = originalFilename.substring(originalFilename.lastIndexOf(".")); //获取文件名最后一个 . 之前的文件名
            originalFilename = UUID.randomUUID().toString() + hzName;

            //上传到指定位置
            headerImg.transferTo(new File("D:\\0.0\\" + originalFilename));

            //还可以获取源生的流
//            headerImg.getInputStream();
        }

        if(photos.length>0){
            for(MultipartFile photo : photos){
                if(!photo.isEmpty()){
                    //获取文件名
                    String originalFilename = photo.getOriginalFilename();
                    //上传到指定位置
                    photo.transferTo(new File("D:\\0.0\\" + originalFilename));
                }
            }
        }

        return "main";
    }
}
