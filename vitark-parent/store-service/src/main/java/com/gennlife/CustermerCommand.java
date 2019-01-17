/**
 * copyRight
 */
package com.gennlife;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/4/26
 * Time: 10:37
 */
@Component
public class CustermerCommand implements TestFeign{
    public Object defaultStores(Map<String, Object> parameters) {
        return "errors";
    }

    @Override
    public String getEnv(String json) {
        return "null";
    }
}
