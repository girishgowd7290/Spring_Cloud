# Spring_Cloud


******************************************* Properties File *******************************************

#Generic
spring.application.name=eureka-naming-server
server.port=8761

# To connect to Naming Server
eureka.client.service-url.default-zone=http://localhost:8761/eureka

#h2 - In memory database
spring.jpa.show-sql=true
spring.h2.console.enabled=true

#Eureka Naming Server 
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

#Ribbon
currency-exchange-service.ribbon.listOfServers=http://xxxx, http://yyyyy


******************************************* Annotations *******************************************
@SpringBootApplication 
    - To start a Spring boot SpringBootApplication

@Bean:
    - returns an object of a particular bean

@RestController
    - To register a service as Rest Service

@GetMapping("uri")
    - To expose a GET service operation

@Repository
    - Mark an interface as a JPA repo to talk with DB

@Entity
    - Enable a DTO to insert Data to DB

@ID:
    - Make the DTO Field primary key of table

@Generated:
    - Uniquely generates a pvt key

@EnableFeignClients("package name")
    - Enables the Feign Rest Service calls

@FeignClient(name="Microserive.appilication.name or Api.G/w.name")
    - Marks the class available/eligible for Feign Rest call 

@RibbonClient(name = "Microserive.appilication.name")
    - Ussed to enable Load balancing

@EnableEurekaServer
    - To Enable a Eureka Server
    - Will be used by other servers to register clients

@EnableDiscoveryClient
    - Used by MS to register themselves with Naming Server

@EnableEurekaClient
    - Used by MS to register themselves with Naming Server

@EnableZuulProxy
    - To enable the ZUUL api gateway on the MS
    
 
******************************************* Dependencies *******************************************


#Eureka Naming Server 
spring-cloud-starter-netflix-eureka-server

# ZUUL Api Gateway
spring-cloud-starter-netflix-zuul
spring-cloud-starter-netflix-eureka-client

#Rest Micro service
spring-boot-starter-web
spring-boot-starter-data-jpa
h2
spring-cloud-starter-openfeign
spring-cloud-starter-netflix-eureka-client
spring-cloud-starter-netflix-ribbon
spring-cloud-starter-config

#FAULT Tolerance
spring-cloud-starter-netflix-hystrix


#SCCS
spring-cloud-config-server
spring-cloud-starter-config
spring-cloud-starter-bus-amqp


#Distribured Tracing
spring-cloud-starter-sleuth
spring-rabbit
spring-cloud-starter-zipkin


Misc :
Environment -> SpringCore
Sampler -> for Sleuth Distributed Tracing


