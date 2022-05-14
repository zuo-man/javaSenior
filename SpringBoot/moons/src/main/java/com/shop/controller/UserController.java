package com.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author shengda
 * @description user CRUD操作
 * @createDate 2022-04-19 15:35:05
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/get/{id}")
    public Result getUserById(@PathVariable("id") Integer id){
        User userByid = userService.getById(id);
        return ReUtil.succ(userByid);
    }
    //查询用户是否唯一
    @GetMapping("/checkOnly/{username}")
    public Result checkOnly(@PathVariable("username") String username){

        User only = userService.getUsername(username);
        if(only == null){//可以添加用户
            return new Result(200, null, "用户不存在", true);
        }else {
            return new Result(399, null, "用户已存在" ,false);
        }
    }


    //添加用户
    @PostMapping("/save")
    public Result saveUser(
//                        @RequestParam("username") String username,
//                         @RequestParam(value = "password", defaultValue = "123") String password,
//                         @RequestPart("salt") MultipartFile salt,    //头像
//                         @RequestParam(value = "nickName", defaultValue = "呆唯") String nickName,  //昵称
//                         @RequestParam(value = "roleName", defaultValue = "用户") String roleName  //角色名称
//                         @RequestParam("gmtCreate")Date gmtCreate,   //创建时间
//                         @RequestParam("gmtModified") Date gmtModified  //更新时间
            @RequestBody HashMap<Object, String> map){

        //判断用户名是否唯一
        String username =  map.get("username");
        User only = userService.getUsername(username);

        if(only == null){

//            String password =  map.get("password");
//            if(password == null){
//                password = "123456";
//            }
//            String nickName =  map.get("nickName");     //昵称
//            if(nickName == ""){
//                nickName = "呆唯";
//            }
//            String roleName =  map.get("roleName");     //角色名称
//            if(roleName == ""){
//                roleName = "用户";
//            }
//            String salt = map.get("salt");              //头像相对路径

            String password = ( map.get("password") == "" ) ? "123456" : map.get("password");
            String nickName = ( map.get("nickName") == "" ) ? "呆唯" : map.get("nickName");
            String roleName = ( map.get("roleName") == "" ) ? "用户" : map.get("roleName");

            String salt = ( map.get("salt") == "" ) ? "/imps/dev.png" : map.get("salt");//上传的文件为空，使用默认图片呆唯

            //获取当前时间    2022-04-19 20:54:54
            SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String gmtCreate = data.format(new Date());


            //添加新用户，创建更新时间相同
            User user = new User(null, username, password, roleName, nickName, salt, gmtCreate, gmtCreate,null);
            userService.save(user);

            return ReUtil.succ(user);



        }else { //用户名已存在
            return new Result(399, null, "用户名已存在", false);
        }
    }


    //更新用户信息
    @PutMapping("/update")
    public Result updateUser(@RequestBody HashMap<Object, String> map){

        Integer id = Integer.valueOf(map.get("id"));
        String username =  map.get("username");
        String password =  map.get("password");
        String salt = map.get("salt");              //头像相对路径
        String nickName =  map.get("nickName");     //昵称
        String roleName =  map.get("roleName");     //角色名称

        //获取当前时间    2022-04-19 20:54:54
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String gmtModified = data.format(new Date());


        //修改用户  ，创建时间不变，更新时间改变
        User user = new User(id, username, password, roleName, nickName, salt, null, gmtModified, null);
        userService.updateById(user);
        //UpdateWrapper实现修改，lambda表达式以防写错属性
//        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
//        wrapper.like(User::getId, id);
//        //修改为：
//        wrapper.set(User::getUsername, username).set(User::getPassword, password)
//                .set(User::getSalt, salt).set(User::getNickName, nickName)
//                .set(User::getRoleName, roleName).set(User::getGmtmodified, gmtModified);
//        userService.update(null, wrapper);

        return ReUtil.succ(null);

    }


    //根据 ids删除 一个或多个用户
    @DeleteMapping("/remove/{ids}")
    public Result deleteBatchRemoveUser(@PathVariable("ids") String[] ids){
        userService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }


    //根据用户名，角色名称模糊查询，并返回分页数据
    @PostMapping("/selectPage/{page}/{limit}")
    public Result selectPageUser(
                            @PathVariable("page") Integer page,
                            @PathVariable("limit") Integer limit,
//                             @PathVariable("username") String username,
//                             @PathVariable("roleName") String roleName
                             @RequestBody HashMap<Object, String> map
    ){
//        Integer page = (Integer) map.get("page");
//        Integer limit = (Integer) map.get("limit");
        String username = map.get("username");
        String roleName = map.get("roleName");

        //自定义    分页查询数据    current:当前页码   size：每页显示几条数据
        Page<User> data = new Page<>(page, limit);

        userService.getUsernameAndRoleName(data, username, roleName);

        return ReUtil.succ(data);
    }



    //获取用户分页  page：当前页码   limit：每页记录数
//    @GetMapping("/{page}/{limit}")
//    public Result getUserPage(@PathVariable("page") Integer page,
//                            @PathVariable("limit") Integer limit){
//
//        //默认   分页查询数据    current:当前页码   size：每页显示几条数据
//        Page<User> userPage = new Page<>(page, limit);
//        //分页查询结果，  null为查询所有数据
//        userService.page(userPage, null);
//
//        return ReUtil.succ(userPage);
//    }


}
