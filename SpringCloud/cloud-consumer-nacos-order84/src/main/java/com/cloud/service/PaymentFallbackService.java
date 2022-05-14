package com.cloud.service;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {


    @Override
    public CommonResult<Payment> paymentSQL(Long id) {

        return new CommonResult<>(399,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}