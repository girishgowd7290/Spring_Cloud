package com.codemads.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * LimitsServiceApplication : A micro service connecting to Spring CLoud Config Server 
 * 
 * @EnableEurekaClient : To discover itself with Eureka Naming Server
 * @EnableHystrix - Used to enabe Fault tolerance
 * 
 * 
 * @author girishgowda
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

}
