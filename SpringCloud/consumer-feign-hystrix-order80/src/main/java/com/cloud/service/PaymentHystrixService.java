package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 1、接口提供方在注册中心。name可以为注册中心的实例名称，加上url属性时，name的值就与注册中心实例名称无关。
 *
 * 如果服务提供方已经注册到注册中心了，那么name或者value的值为：服务提供方的服务名称。必须为所有客户端指定一个name或者value
 * @FeignClient(value="run-product",fallback = ProductClientServiceFallBack.class)
 *
 * 2、单独的一个http接口，接口提供方没有注册到注册中心。
 * @FeignClient(name="runClient11111",url="localhost:8001")
 * 此处name的值为:调用客户端的名称。
 *
 * fallback：若8001宕机或其他问题，则降级到 PaymentFallbackService类中方法，比如ok方法
 *          但是有服务降级处理，让客户端在服务端不可用时也会获得提示信息而不会挂起耗死服务器
 */

@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);


}
