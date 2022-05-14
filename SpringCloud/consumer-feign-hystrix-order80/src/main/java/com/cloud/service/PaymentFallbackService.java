package com.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---service，paymentInfo_OK，服务器已宕机";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---service，paymentInfo_TimeOut，服务器已宕机";
    }
}
