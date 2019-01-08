/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import java.security.Principal;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2017/11/21
 * Time: 20:31
 */
@RestController
@RequestMapping("/rws")
@Order(-1)
public class TestController {
    @Autowired
    private TestFeign testFeign;
    @Value("${myconfig}")
    private String env;
    @RequestMapping(value="/getEnv")
    public String getEnv(Principal principal, @RequestBody String json){

        String env = "";
        try {
             env = testFeign.getEnv(json);
            return env;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return env;
    }
}
