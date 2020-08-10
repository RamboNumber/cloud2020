package com.rambo.springcloud.controller;

import com.rambo.springcloud.common.ResultBody;
import com.rambo.springcloud.entities.Payment;
import com.rambo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;  //服务注册发现

    @PostMapping("/create")
    public ResultBody<Payment> create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        LOGGER.info("result : ", result);
        if (result > 0) {
            return new ResultBody<>(200, "插入数据成功,serverPort:"+serverPort, payment);
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

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            LOGGER.info("*****service: {}", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            LOGGER.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }




}
