package com.rambo.springcloud.controller;

import com.rambo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/3 23:10
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_ok(id);
        return result;
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_timeout(id);
        return result;
    }

    // 服务熔断
    @GetMapping("/payment/circuitBreaker/{id}")
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);

        return result;
    }
}
