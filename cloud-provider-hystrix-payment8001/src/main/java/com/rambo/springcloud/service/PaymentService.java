package com.rambo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeout(Integer id) {
        int time = 5;
//        int age =1/0;

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName()+ " paymentInfo_timeout, id: " + id + "\t" + "O(∩_∩)O"
                + "耗时"+"秒钟";
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName()+ " 系统繁忙请稍后再试, id: " + id + "\t" + "/(ㄒoㄒ)/~~";
    }


}
