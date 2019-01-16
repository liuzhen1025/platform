/**
 * copyRight
 */
package com.gennlife;

import com.hmily.tcc.common.utils.IdWorkerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value="/getEnv",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getEnv(Principal principal, @RequestBody String json){

        IdWorkerUtils utils = IdWorkerUtils.getInstance();
        utils.buildPartNumber();
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
