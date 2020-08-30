package com.rambo.springcloud.controller;

import com.rambo.springcloud.common.ResultBody;
import com.rambo.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

//    public static final  String PAYMENT_URL = "http://localhost:8001";
    public static final  String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public ResultBody<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, ResultBody.class);
    }

    @GetMapping("/payment/get")
    public  ResultBody<Payment> getPayment(@RequestParam("id") Integer id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/select/",ResultBody.class, map);
    }

    @PostMapping("/payment/create1")
    public ResultBody<Payment> create1(@RequestBody Payment payment) {
        ResponseEntity<ResultBody> entity = restTemplate.postForEntity(PAYMENT_URL+"/payment/create", payment, ResultBody.class);
        LOGGER.info("entity is : {}", entity.toString());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new ResultBody<>(444, "调用失败");
    }
}
