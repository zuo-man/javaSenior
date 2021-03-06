package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "成功，serverPort：" + serverPort, result);
        }else {
            return new CommonResult(399, "失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***结果：" + payment);
        if(payment != null){
            return new CommonResult(200, "get成功，serverPort：" + serverPort, payment);
        }else {
            return new CommonResult(399, "get失败，ID：" + id, null);
        }
    }

    @GetMapping("/lb")
    public String getPayment(){

        return serverPort;
    }



}
