/**
 * copyRight
 */
package com.gennlife.config;

import org.springframework.core.env.EnumerablePropertySource;

import java.util.Map;
import java.util.Properties;

/**
 * 自定义属性
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/17
 * Time: 20:00
 */
public class CustomerPropertySource extends EnumerablePropertySource<Properties> {

    public CustomerPropertySource(String name, Properties source) {
        super(name, source);
    }
    @Override
    public String[] getPropertyNames() {
        return source.keySet().toArray(new String[source.size()]);
    }

    @Override
    public Object getProperty(String s) {
        return source.get(name);
    }
}
