package com.shop.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;

//全局返回 工具类
@Component
public class ReUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static Result succ(Object data){
        return new Result(200, data, "成了", true);
    }
    public static Result fail(Object data){
        return new Result(399, data, "寄了", false);
    }




    public Result succToken(String token, Object data){
        //静态方法不能直接调用非静态方法，只能new一个对象来调用
        Boolean is = new ReUtil().checkToken(token);
        if(is){
            return new Result(200, data, "成功", true);
        }
        return new Result(399,  null, "寄了", false);
    }

    private boolean checkToken(String check){
        Object value = redisTemplate.opsForValue().get(check);
        if (value!=null){
            return true;
        }else {
            return false;
        }
    }


}
