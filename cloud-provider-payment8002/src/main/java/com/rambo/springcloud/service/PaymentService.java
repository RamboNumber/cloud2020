package com.rambo.springcloud.service;

import com.rambo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 翟博文 on 2020/7/28 23:08
 */
public interface PaymentService {

    int create(Payment payment);

    List<Payment> getPaymentList();

    Payment getPaymentById(@Param("id") Integer id);
}
