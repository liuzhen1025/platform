package com.gennlife;

import com.gennlife.rws.fallbak.DeptClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liuzhen
 *         Created by liuzhen.
 *         Date: 2018/4/25
 *         Time: 14:53
 */
@FeignClient(value = "user-service"/*,fallback = CustermerCommand.class*/,fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface TestFeign {
    @RequestMapping(method = RequestMethod.POST ,value="/user-service/rws/getEnv",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String getEnv(String json);
}
