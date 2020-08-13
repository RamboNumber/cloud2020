package com.rambo.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author rambo.zhai
 * @date 2020/8/13
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL+"/payment8004/zk", String.class);
    }
}
