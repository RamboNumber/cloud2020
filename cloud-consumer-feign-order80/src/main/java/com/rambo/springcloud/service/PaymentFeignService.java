package com.rambo.springcloud.service;

import com.rambo.springcloud.common.ResultBody;
import com.rambo.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/1 22:49
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/select/{id}")
    ResultBody<Payment> getPaymentById(@PathVariable("id") Integer id);
}
