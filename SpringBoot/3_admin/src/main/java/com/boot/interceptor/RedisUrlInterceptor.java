package com.boot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
//设置此拦截器，每一个登录请求进来让访问量加一
public class RedisUrlInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置访问页面Key名称
        String uri = request.getRequestURI();

        //默认每次访问当前 uri对应的值value 就会计数 +1 ，每个页面都会加一
        redisTemplate.opsForValue().increment(uri);

        return true;
    }

}
