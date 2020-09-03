package com.rambo.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/9/3 23:04
 */
@Service
public class PaymentService {
    public static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName()+ " paymentInfo_ok, id: " + id + "\t" + "O(∩_∩)O";
    }

    public String paymentInfo_timeout(Integer id) {
        int time = 3;

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName()+ " paymentInfo_timeout, id: " + id + "\t" + "O(∩_∩)O"
                + "耗时"+time+"秒钟";
    }


}
