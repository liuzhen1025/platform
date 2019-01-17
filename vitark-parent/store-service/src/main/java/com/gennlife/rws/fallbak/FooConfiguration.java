package com.gennlife.rws.fallbak;

import feign.Contract;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 默认情况下，Feign 使用Hystrix 封装所有请求，而hystrix如果使用thread隔离策略，
 * 那么在线程切换时会导致TreadLocal类型的变量丢失，导致出现错误，
 * 解决办法：
 * 1）：将Hystrix 隔离策略改为SEMAPHORE；
 * 2）：使用Feign.builder() 禁止使用hystrix 封装Feign请求。
 * 3）：自定义Hystrix隔离策略，参见https://blog.csdn.net/songhaifengshuaige/article/details/80345012，参见FeignHystrixConcurrencyStrategy
 *
 */
//@Configuration
public class FooConfiguration {
   // @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
    //@Bean
    //@Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    /*@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }*/
}
