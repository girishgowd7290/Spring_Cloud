package com.codemads.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. 
 * With the Config Server, you have a central place to manage external properties for applications across all environments. 
 * The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, 
 * so they fit very well with Spring applications but can be used with any application running in any language. 
 * As an application moves through the deployment pipeline from dev to test and into production 
 * 
 * @EnableConfigServer - Used to mark this service as Spring Cloud Config Server
 * 
 * URL to connect : spring.cloud.config.uri=http://localhost:8888
 * 
 * @author girishgowda
 *
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}
