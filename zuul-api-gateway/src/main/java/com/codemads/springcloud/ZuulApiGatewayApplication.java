package com.codemads.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * 
 * ZuulApiGatewayApplication used Spring CLoud Zuul API Gateway.
 * You will also see how to use Zuul to filter requests that are made through the proxy service.
 * 
 * @EnableZuulProxy - Used to enable this Microservice as a ZUUL Proxy / API
 * @EnableDiscoveryClient - Used to register this micro servcie with Eureka Naming Server
 * 
 * ZUUL API G/w Port : 8765
 * 
 * Eureka Naming Server : http://localhost:8761/eureka
 * 
 * 
 * Reference Url :https://spring.io/guides/gs/routing-and-filtering/
 * 
 * @author girishgowda
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
