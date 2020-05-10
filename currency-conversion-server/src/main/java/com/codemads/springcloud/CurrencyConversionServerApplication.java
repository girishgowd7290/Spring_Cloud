package com.codemads.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * CurrencyConversionServerApplication :
 * 
 * @EnableDiscoveryClient :  To register ther service with Eureka naming server
 * @EnableFeignClients("com.codemads.springcloud") - To enable Feign serivce to call Rest Services
 * 
 * @author girishgowda
 *
 */
@EnableFeignClients("com.codemads.springcloud")
@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyConversionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServerApplication.class, args);
	}
	
	
	/**
	 * Sampler class are used by Spring Cliud Sleuth to have distributed traciing
	 * 
	 * Spring Cloud Sleuth provides Spring Boot auto-configuration for distributed tracing.
	 * 
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
