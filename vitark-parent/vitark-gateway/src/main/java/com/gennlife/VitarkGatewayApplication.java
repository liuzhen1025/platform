package com.gennlife;

import com.gennlife.filter.ZuulPostFilter;
import com.gennlife.filter.ZuulPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableZuulServer
@EnableEurekaClient
@EnableZuulProxy
//@EnableOAuth2Sso
public class VitarkGatewayApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(VitarkGatewayApplication.class, args);

	}
	@Bean
	public ZuulPostFilter zuulPostFilter(){
		return new ZuulPostFilter();
	}
	@Bean
	public ZuulPreFilter zuulPreFilter(){
		return new ZuulPreFilter();
	}
}
