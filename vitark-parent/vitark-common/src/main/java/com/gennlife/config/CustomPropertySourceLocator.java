/**
 * copyRight
 */
package com.gennlife.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 自定义属性配置 需要协同spring.factories 使用，暂时未用到
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/18
 * Time: 16:04
 */
@Configuration
public class CustomPropertySourceLocator implements PropertySourceLocator {
    @Override
    public PropertySource<?> locate(Environment environment) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("application.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        PropertiesPropertySource source = new PropertiesPropertySource("customPropertySourceLocator",properties);
        return source;
    }

}
