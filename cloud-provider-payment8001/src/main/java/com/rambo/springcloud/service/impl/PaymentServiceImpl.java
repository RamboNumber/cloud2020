package com.rambo.springcloud.service.impl;

import com.rambo.springcloud.dao.PaymentMapper;
import com.rambo.springcloud.entities.Payment;
import com.rambo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 翟博文 on 2020/7/28 23:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public List<Payment> getPaymentList() {
        return null;
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentMapper.getPaymentById(id);
    }

    public static void main(String[] args) {
        PaymentServiceImpl paymentService = new PaymentServiceImpl();
        Payment payment = paymentService.getPaymentById(1);
        System.out.println("aaa == " + payment);
    }
}
