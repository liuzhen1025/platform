package com.gennlife.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源访问限制配置{@link ResourceServerConfigurerAdapter}
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
