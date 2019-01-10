package com.gennlife;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
@EnableHystrix
@EnableZipkinServer
public class VitarkMonitorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitarkMonitorsApplication.class, args);
	}
   /* @Bean
    public HttpHeadersProvider httpHeadersProvider() {
        return new HttpHeadersProvider();
    }*/
	/*@Bean
	public ServletRegistrationBean getServlet(){

		HystrixMetricsStreamServlet  streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean bean =new ServletRegistrationBean(streamServlet);
		bean.setLoadOnStartup(1);
		bean.addUrlMappings("/hystrix.stream");
		bean.setName("HystrixMetricsStreamServlet");
		return  bean;
	}*/
}
