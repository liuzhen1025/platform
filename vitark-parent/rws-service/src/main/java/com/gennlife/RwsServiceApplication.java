package com.gennlife;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RwsServiceApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RwsServiceApplication.class, args);
		/*Ser bean = run.getBean(Ser.class);
		System.out.println(bean.getMyName());*/

	}
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor(){
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {

				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
						SecurityContextHolder.getContext().getAuthentication().getDetails();
				requestTemplate.header("Authorization", "bearer " + details.getTokenValue());
			}
		};
	}
	/*@Component
	public static class Ser{
		@Value("${configServer.ip}")
		private String myName;

		public String getMyName() {
			return myName;
		}

		public void setMyName(String myName) {
			this.myName = myName;
		}
	}*/

}
