package com.shop.controller;

import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.pojo.User;
import com.shop.pojo.Change;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/index")
public class login {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    //前端 传输用户名密码，生成token至redis数据库
    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password){
        //登录验证用户名密码
        User user = userService.loginByUsernameAndByPassword(username, password);
        if(user != null) {//登录成功
            //随机生成 Token令牌至redis数据库，过期时间 30L：30分钟
            String token = (user.getId()).toString() + UUID.randomUUID() + "";
            redisTemplate.opsForValue().set(token, (user.getId()).toString(), Duration.ofMinutes(30L));

//            return new ReUtil().succToken(token, user);
           return new Result(200, token, null, "用户存在", true);
        }
        return ReUtil.fail(user);
//           return new Result(399, null, "失败", false);
    }

    /**
     *  验证 Token
     *  获取前端传输的 Token，查询token键所对应的 id值，再把user数据返回前端
     */
    @GetMapping("/getUserinfo")
    public Result getUserinfo(@RequestParam String token){

        String check = (String) redisTemplate.opsForValue().get(token);

        if(check != null){
            User user = userService.getById(check);

            Change change = Change.UserChange(user);

            return new Result(200, null, change, "用户登录成功", true);
        }else {
            return ReUtil.fail(null);
        }
    }

    /**
     * 前端注销账号，删除 Token
     */
    @PostMapping("/logout")
    public Result logout(@RequestBody HashMap<Object, String> map){

        redisTemplate.delete(map.get("token"));

        return new Result(200, null, "用户已注销", true);
    }




}
