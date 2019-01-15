package com.gennlife;

import com.gennlife.rws.fallbak.DeptClientServiceFallbackFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/4/25
 * Time: 14:53
 *
 * 默认情况下，Feign 使用Hystrix 封装所有请求，而hystrix如果使用thread隔离策略，
 * 那么在线程切换时会导致TreadLocal类型的变量丢失，导致出现错误，
 * 解决办法：
 * 1）：将Hystrix 隔离策略改为SEMAPHORE；
 * 2）：使用Feign.builder() 禁止使用hystrix 封装Feign请求，feign.hystrix.enable=false参见FooConfiguration, 在FeignClient上使用configuration属性使其生效
 * 3）：自定义Hystrix隔离策略，参见https://blog.csdn.net/songhaifengshuaige/article/details/80345012，参见FeignHystrixConcurrencyStrategy
 */
@FeignClient(value = "user-service"/*,fallback = CustermerCommand.class*//**//*,configuration = FooConfiguration.class 禁用Feign 封装Hystrix*/,fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface TestFeign {
    @HystrixCommand(threadPoolKey = "userService"/*,commandProperties = @HystrixProperty(name="execution.isolation.strategy",value = "SEMAPHORE")*/)
    @RequestMapping(method = RequestMethod.POST ,value= "/user-service/rws/getEnv",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String getEnv(String json);
}
