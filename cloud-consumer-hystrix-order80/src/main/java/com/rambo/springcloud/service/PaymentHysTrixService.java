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
 * @date 2020/9/7 22:33
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentHysTrixService {


    @GetMapping("payment/hystrix/ok/{id}")
    String getPaymentById(@PathVariable("id") Integer id);


    @GetMapping("payment/hystrix/timeout/{id}")
    String paymentInfo_timeout(@PathVariable("id") Integer id) ;
}
