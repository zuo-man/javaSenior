package com.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        //模拟验证码发送
        verifyCode("1");

        getRedisCode("1", "5242");
    }


    //1 生成4位数字验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for(int i = 0; i < 4; i ++){
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    //2. 每个手机每天只能发送三次，验证码放到redis中，设置过期时间120s
    public static void verifyCode(String phone){
        //连接reids
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");

        //拼接key
        //手机发送次数key
        String countKey = "VerifyCode" + phone + ":count";
        //验证码
        String codeKey = "VerifyCode" + phone + ":code";

        //每个手机每天只能发送三次      get：获取countKey键对应的 value值
        String count = jedis.get(countKey);
        if(count == null){
            //没有发送次数，第一次发送
            //设置发送次数为 1
            jedis.setex(countKey, 24*60*60, "1");
        }else if(Integer.parseInt(count) <= 2){
            //发送次数 + 1
            jedis.incr(countKey);
        }else if(Integer.parseInt(count) > 2){
            System.out.println("今天发送次数已经超过三次，不能发送验证码了");
            jedis.close();
            return;
        }

        //发送验证码到redis里面
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }

    //3. 验证码校验
    public static void getRedisCode(String phone, String code){
        //从reids获取验证码
        Jedis jedis = new Jedis("47.96.175.143", 6379);
        jedis.auth("root");
        //验证码key
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        //判断
        if(redisCode.equals(code)){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        jedis.close();
    }
}
