package com.rambo.springcloud.controller;

import com.rambo.springcloud.common.ResultBody;
import com.rambo.springcloud.entities.Payment;
import com.rambo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 翟博文 on 2020/7/28 23:12
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymenController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymenController.class);
    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResultBody<Payment> create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        LOGGER.info("result : ", result);
        if (result > 0) {
            return new ResultBody<>(200, "插入数据成功");
        }
        return new ResultBody<>(433, "插入失败");
    }

    @GetMapping("/select")
    public ResultBody<Payment> select(@RequestParam(value = "id", required = false) Integer id) {
        LOGGER.info("request para is : {}", id);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new ResultBody<>(200, "select success", payment);
        }
        return new ResultBody<>(433, "select fail, no data"+id);
    }




}
