package com.rambo.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rambo.springcloud.common.ResultBody;
import com.rambo.springcloud.entity.Payment;
import com.rambo.springcloud.service.PaymentHysTrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/7 22:38
 */
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallBack")
public class PaymentHysTrixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentHysTrixController.class);

    @Autowired
    private PaymentHysTrixService paymentHysTrixService;


    @GetMapping("consumer/hystrix/ok/{id}")
    String getPaymentById(@PathVariable("id") Integer id) {
        String result = paymentHysTrixService.getPaymentById(id);
        return result;
    }


    @GetMapping("consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    String paymentInfo_timeout(@PathVariable("id") Integer id) {
        int a = 1/0;
        String result = paymentHysTrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试，/(ㄒoㄒ)/~~,  id == " + id;
    }

    // 全局fallback
    public String paymentGlobalFallBack(Integer id) {
        return "我是全局fallback  id == " + id;
    }
}
