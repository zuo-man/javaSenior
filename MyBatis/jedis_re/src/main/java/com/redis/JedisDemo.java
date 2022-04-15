package com.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisDemo {
    public static void main(String[] args) {
        //创建Jedis对象
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");


        //测试
        String value = jedis.ping();
        System.out.println(value);

        //关闭
        jedis.close();
    }

    //操作 Zset
    @Test
    public void redisZset(){
        //创建Jedis对象
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");

        jedis.zadd("成绩", 100d, "小优");
        Set<String> score = jedis.zrange("成绩", 0, -1);
        System.out.println(score);
    }

    //操作 Hash
    @Test
    public void redisHash(){
        //创建Jedis对象
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");

        jedis.hset("Users", "姓名", "小优");
        String hget = jedis.hget("Users", "姓名");

        System.out.println(hget);


        //多个对象
        Map<String, String> map = new HashMap<>();
        map.put("姓名", "无暇");
        map.put("电话", "123");
        map.put("年龄", "18");
        jedis.hmset("用户", map);

        //获取
        List<String> hmget = jedis.hmget("用户", "姓名", "电话", "年龄");
        System.out.println(hmget);
    }

    //操作Set
    @Test
    public void redisSet(){
        //创建Jedis对象
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");

        jedis.sadd("Set姓名", "千姬", "唯", "唯");
        // 0 -1 ：表示取出所有值
        Set<String> name = jedis.smembers("Set姓名");
        System.out.println(name);
    }

    //操作List
    @Test
    public void redisList(){
        //创建Jedis对象
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");

        jedis.lpush("姓名", "千姬", "唯", "卡萝");
        // 0 -1 ：表示取出所有值
        List<String> name = jedis.lrange("姓名", 0, -1);
        System.out.println(name);
    }

    //操作 key String
    @Test
    public void redisKey(){
        //创建Jedis对象
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");

        //添加
        jedis.set("name", "小优");
        //获取
        String name = jedis.get("name");
        System.out.println(name);

        //设置多个key - value
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        //获取所有keys
        Set<String> keys = jedis.keys("*");
        for(String key : keys ){
            System.out.println(key);
        }
    }
}
