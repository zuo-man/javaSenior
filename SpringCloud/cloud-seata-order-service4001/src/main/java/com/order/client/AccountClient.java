package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient("account-service")
public interface AccountClient {

    @PutMapping("/account/{userId}/{money}")
    void deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money);
}
