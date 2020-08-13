package com.rambo.springcloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/8/12 22:47
 */
@RestController
@Slf4j
@RequestMapping("/payment8004")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentZK() {
        return "springCloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
