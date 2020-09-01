package com.rambo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/8/31 22:08
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
