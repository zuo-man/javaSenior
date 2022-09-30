package com.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.User;
import com.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据ID查询用户")
    @GetMapping("/get/{id}")
    public Result getUserById(@PathVariable("id") Integer id){
        User userByid = userService.getById(id);
        return ReUtil.succ(userByid);
    }
    @ApiOperation("查询用户是否唯一")
    @GetMapping("/checkOnly/{username}")
    public Result checkOnly(@PathVariable("username") String username){

        User only = userService.getUsername(username);
        if(only == null){//可以添加用户
            return new Result(200, null, "用户不存在", true);
        }else {
            return new Result(399, null, "用户已存在" ,false);
        }
    }


    @ApiOperation("添加用户")
    @PostMapping("/save")
    public Result saveUser(@RequestBody User user){

        //判断用户名是否唯一
        String username = user.getUsername();
        User only = userService.getUsername(username);

        if(only == null){
            String password = ( user.getPassword() == "" ) ? "123" : user.getPassword();
            String nickName = ( user.getNickName() == "" ) ? "呆唯" : user.getNickName();
            String roleName = ( user.getRoleName() == "" ) ? "呆唯" : user.getRoleName();
            String salt = ( user.getSalt() == "" ) ? "/imps/dev.png" : user.getSalt();

            //获取当前时间    2022-04-19 20:54:54
            SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String gmtCreate = data.format(new Date());

            //添加新用户，创建更新时间相同
            user = new User(null, username, password, roleName, nickName, salt, gmtCreate, gmtCreate,null);
            userService.save(user);

            return ReUtil.succ(user);
        }else { //用户名已存在
            return new Result(399, null, "用户名已存在", false);
        }
    }


    @ApiOperation("更新用户信息")
    @PutMapping("/update")
    public Result updateUser(@RequestBody User user){

        //获取当前时间    2022-04-19 20:54:54
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String gmtModified = data.format(new Date());

        //修改用户  ，创建时间不变，更新时间改变
        user = new User(user.getId(), user.getUsername(), user.getPassword(), user.getRoleName(),
                        user.getNickName(), user.getSalt(), null, gmtModified, null);
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


    @ApiOperation("根据 ids删除 一个或多个用户")
    @DeleteMapping("/remove/{ids}")
    public Result RemoveBatchUser(@PathVariable("ids") String[] ids){
        userService.removeBatchByIds(Arrays.asList(ids));

        return ReUtil.succ(null);
    }


    @ApiOperation("根据用户名，角色名称模糊查询，并返回分页数据")
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



    //@ApiOperation("获取用户分页  page：当前页码   limit：每页记录数")
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
