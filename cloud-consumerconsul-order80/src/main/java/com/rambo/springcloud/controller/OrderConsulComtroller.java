package com.rambo.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/8/26 22:09
 */
@RestController
public class OrderConsulComtroller {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);
    }

}
