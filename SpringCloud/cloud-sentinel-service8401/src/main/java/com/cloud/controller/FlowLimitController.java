package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        //测试线程数限流，每个线程先停800ms
//        try {TimeUnit.MILLISECONDS.sleep(800);}catch (InterruptedException e){e.printStackTrace();}

        return "testA.......";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info((Thread.currentThread().getName() + "\t" + "...testB"));

        return "testB.......";
    }

    @GetMapping("/testC")
    public String testC(){
        //暂停线程，测试熔断
//        try {TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){e.printStackTrace();}
//        log.info("testC  测试RT慢调用比例");

        //测试异常比例
//        int age = 1/0;

        return "testC........";
    }

    /**
     * sentinel系统默认提示： Blocked by Sentinel (flow limiting)
     * 参数索引，默认从0开始：0 表示传入的p1参数 ，1表示 传入的p2参数
     */
    //热点限流
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        //int i = 1/0;  //兜底方法不会执行，直接抛异常

        return "......testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){

        return "deal_testHotKey，  兜底方法执行";
    }



}
