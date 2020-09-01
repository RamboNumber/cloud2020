package com.rambo.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.rambo.springcloud.common.ResultBody;
import com.rambo.springcloud.entity.Payment;
import com.rambo.springcloud.service.PaymentFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/1 22:55
 */
@RestController
public class OrderFeignController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFeignController.class);

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/getPayment/{id}")
    public ResultBody<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return paymentFeignService.getPaymentById(id);
    }
}
