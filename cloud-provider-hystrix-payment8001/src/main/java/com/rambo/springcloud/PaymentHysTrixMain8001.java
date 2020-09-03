package com.rambo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/3 23:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentHysTrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHysTrixMain8001.class, args);
    }
}
