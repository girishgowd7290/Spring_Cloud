package com.codemads.springcloud.EurekaNamingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * A service registry is useful because it enables client-side load-balancing and decouples service providers from consumers without the need for DNS.
 * @EnableEurekaServer - Used to enable this microservice as a Eureka Naming server to register services
 * 
 * PORT : 8761
 * @author girishgowda
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingServerApplication.class, args);
	}

}
