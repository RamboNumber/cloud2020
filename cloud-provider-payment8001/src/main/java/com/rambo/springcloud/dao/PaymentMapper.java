package com.rambo.springcloud.dao;

import com.rambo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 翟博文 on 2020/7/28 22:55
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    List<Payment> getPaymentList();

    Payment getPaymentById(@Param("id") Integer id);
}
