package com.gennlife;

import com.hmily.tcc.common.utils.IdWorkerUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@ImportResource("classpath:applicationContext.xml")
@MapperScan("com.gennlife.rws.mapper")
public class RwsServiceApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(RwsServiceApplication.class, args);
	}
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor(){
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {

                SecurityContext context = SecurityContextHolder.getContext();
                Authentication authentication = context.getAuthentication();
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
						authentication.getDetails();
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
