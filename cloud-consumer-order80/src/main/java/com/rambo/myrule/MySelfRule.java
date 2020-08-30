package com.rambo.myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rambo
 * @version 1.0
 * @date 2020/8/30 22:27
 */
@Configuration
public class MySelfRule {
    private static final Logger LOGGER = LoggerFactory.getLogger(MySelfRule.class);

    @Bean
    public IRule myRule() {
//        return new RandomRule();// 定义为随机
//        return new RetryRule();// 重试， 先按照RoundRobinRule（轮询）获取服务，如果获取服务失败， 则在指定时间内会重试，获取可用的服务
        return new BestAvailableRule();// 先过滤调由于多次访问故障而处于断路器跳闸状态的服务， 然后选择一个并发量最小的服务
    }
}
