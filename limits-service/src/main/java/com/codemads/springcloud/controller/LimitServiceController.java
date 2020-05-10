/**
 * 
 */
package com.codemads.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemads.springcloud.beans.Configuration;
import com.codemads.springcloud.beans.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * LimitServiceController is a rest controller class .
 * 
 * @RestController - Use this annotation to enable a class as Rest controller
 * 
 * @author girishgowda
 *
 */
@RestController
public class LimitServiceController {

	@Autowired
	private Configuration configuration;
	
	
	@GetMapping(value="/limits")
	public LimitConfiguration getLimits() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	/**
	 * This is a GET method
	 * 
	 * @HystrixCommand(fallbackMethod = "<New Method Name>") - Used for Fault tolerance, 
	 * walks you through the process of applying circuit breakers to potentially failing method calls by using the Netflix Hystrix fault tolerance library.
	 * 
	 * @return
	 */
	@GetMapping(value="/limitsHystrix")
	@HystrixCommand(fallbackMethod = "fallbackLimitsHystrix")
	public LimitConfiguration getLimitsHystrix() {
		throw new RuntimeException();
	}
	
	public LimitConfiguration fallbackLimitsHystrix() {
		return new LimitConfiguration("9999999999999", "9");
	}
	
	
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello";
	}
}
