/**
 * copyRight
 */
package com.gennlife.rws.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/12
 * Time: 16:46
 */
@Configuration
public class StrategyRegister {
    @PostConstruct
    public void init() {
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new FeignHystrixConcurrencyStrategy());
        /*HystrixPlugins.getInstance().registerEventNotifier(new HystrixEventNotifier() {
            @Override
            public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
                new FeignHystrixConcurrencyStrategy();
                super.markEvent(eventType, key);
            }

            *//*@Override
            public void markCommandExecution(HystrixCommandKey key, HystrixCommandProperties.ExecutionIsolationStrategy isolationStrategy, int duration, List<HystrixEventType> eventsDuringExecution) {
                new FeignHystrixConcurrencyStrategy();
                super.markCommandExecution(key, isolationStrategy, duration, eventsDuringExecution);
            }*//*
        });*/
    }
}
