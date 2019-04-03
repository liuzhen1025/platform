package com.gennlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.redis.cache.RedisCacheManager;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterApplication {
    @CachePut
	public static void main(String[] args) {
        new SpringApplicationBuilder(RegisterCenterApplication.class).run(args);
	}
}
