package com.rambo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/7 22:30
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHysTrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHysTrixMain80.class);
    }
}
