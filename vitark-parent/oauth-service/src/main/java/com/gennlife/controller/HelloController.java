package com.gennlife.controller;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试controller
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "order";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public void doLogin(String username,String password){
        System.out.println(username);
    }
}
