package com.codemads.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
/**
 * CurrencyExchangeServerApplication : Microservice to give the exchange rate of a currency
 * 
 * 
 * @EnableEurekaClient : Used to register itself with Eureka Naming Server
 * 
 * @author girishgowda
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class CurrencyExchangeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServerApplication.class, args);
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
