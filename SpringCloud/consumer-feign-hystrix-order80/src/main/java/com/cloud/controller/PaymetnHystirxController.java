package com.cloud.controller;

import com.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymetnHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){

        return paymentHystrixService.paymentInfo_OK(id);
    }



    /**
     * @HystrixCommand ：标注的方法TimeOut若超时，异常 等错误
     *                  超过 1秒，则执行 TimeoutHandler方法
     *
     * @HystrixCommand 注解 能对某个一个接口定制 Hystrix的超时时间。
     * 通过修改 execution.isolation.thread.timeoutInMilliseconds 属性可以设置超时时间，
     * 通过设置 fallbackMethod 可以设置超时后响应的格式
     */

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "15000")
    })
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        int atg = 1/0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);

        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){

        return "消费者 兜底方法执行， 系统繁忙或运行报错";
    }





}
