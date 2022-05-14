package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){

        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK，id： " + id + "\t";
    }


    /**
     * @HystrixCommand ：标注的方法TimeOut若超时，异常 等错误
     *                  超过 3秒，则执行 TimeoutHandler方法
     *
     * @HystrixCommand 注解 能对某个一个接口定制 Hystrix的超时时间。
     * 通过修改 execution.isolation.thread.timeoutInMilliseconds 属性可以设置超时时间，
     * 通过设置 fallbackMethod 可以设置超时后响应的格式
     */



    @HystrixCommand(fallbackMethod = "TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
//        int timeNumber = 3;//假设业务逻辑处理 5s
        //int num = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "线程池： " + Thread.currentThread().getName() + "  Timeout，id： " + id + "\t";
    }
    public String TimeOutHandler(Integer id){

        return "兜底方法执行，线程池： " + Thread.currentThread().getName() + "    ，系统繁忙或运行报错";
    }



    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })

    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //相当于UUID.random 随机生成，且不带 - 号

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }



}
