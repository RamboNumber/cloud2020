package com.rambo.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/8/17 23:12
 */
@RestController
public class PaymentConsulCtrl {
    private static final Logger logger = LoggerFactory.getLogger(PaymentConsulCtrl.class);

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "springCloud with consul: " + port + "\t" + UUID.randomUUID().toString();
    }
}
