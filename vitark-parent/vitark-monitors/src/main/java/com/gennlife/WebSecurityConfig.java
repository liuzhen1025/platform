package com.gennlife;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略css.jq.img等文件
        web.ignoring().antMatchers("/monitor/**.html", "/monitor/**.css", "/monitor/img/**", "/monitor/**.js", "/monitor/third-party/**","/monitor/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //HTTP with Disable CSRF
                .authorizeRequests() //Authorize Request Configuration
                .antMatchers("/monitor/login",
                        "/monitor/api/**",
                        "/monitor/**/heapdump",
                        "/monitor/**/loggers",
                        "/monitor/**/liquibase",
                        "/monitor/**/logfile",
                        "/monitor/**/flyway",
                        "/monitor/**/auditevents",
                        "/monitor/**/jolokia").permitAll() //放开"/api/**"：为了给被监控端免登录注册并解决Log与Logger冲突
                .and()
                .authorizeRequests()
                .antMatchers("/monitor/**").hasRole("USER")
                .antMatchers("/monitor/**").authenticated()
                .and() //Login Form configuration for all others
                .formLogin()
                .loginPage("/monitor/login.html")
                .loginProcessingUrl("/monitor/login").permitAll()
                .defaultSuccessUrl("/monitor/")
                .and() //Logout Form configuration
                .logout()//.logoutUrl()logoutUrl("/manager/logout")
                //.deleteCookies("remove")
                .logoutSuccessUrl("/monitor/login.html").permitAll()
                .and()
                .httpBasic();

    }
}
