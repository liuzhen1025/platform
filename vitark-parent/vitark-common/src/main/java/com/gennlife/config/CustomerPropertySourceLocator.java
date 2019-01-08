/**
 * copyRight
 */
package com.gennlife.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 自定义配置属性原，主要用来配置微服务中一些基本组件的ip及端口
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/17
 * Time: 19:36
 */
//@Configuration
public class CustomerPropertySourceLocator implements PropertySourceLocator {
    private static Logger logger = LoggerFactory.getLogger(CustomerPropertySourceLocator.class);
    @Override
    public PropertySource<?> locate(Environment environment) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("application.properties")));
        } catch (IOException e) {
            logger.error("errors in loading customers properties cause by "+e.toString());
            throw new RuntimeException(e.toString());
        }
        CustomerPropertySource source = new CustomerPropertySource("myPropertySource",properties);
        return source;
    }

    @Bean
    public CustomerPropertySourceLocator locator(){
        return  new CustomerPropertySourceLocator();
    }
}
