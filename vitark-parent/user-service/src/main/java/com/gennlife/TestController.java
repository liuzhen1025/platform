/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2017/11/21
 * Time: 20:31
 */
@RestController
@RequestMapping("/rws")
@Order(-1)
@RefreshScope
public class TestController {
    @Value("${profile.active}")
    private String env;
    @RequestMapping(value="/getEnv",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getEnv(@RequestBody String json){
        System.out.println("server 2");
        return json;
    }
}
