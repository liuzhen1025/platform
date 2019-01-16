/**
 * copyRight
 */
package com.gennlife.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/17
 * Time: 16:04
 * 拦截所有请求
 */
public class BaseSecurityResource extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new OAuth2AuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .mvcMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
