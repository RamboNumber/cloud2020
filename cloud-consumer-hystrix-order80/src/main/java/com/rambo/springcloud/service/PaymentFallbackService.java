package com.rambo.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/9 22:20
 */
@Component
public class PaymentFallbackService implements PaymentHysTrixService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentFallbackService.class);

    @Override
    public String getPaymentById(Integer id) {
        return "PaymentFallbackService fallback OK";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "PaymentFallbackService fall back timeout";
    }
}
