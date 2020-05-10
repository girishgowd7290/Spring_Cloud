package com.codemads.springcloud.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codemads.springcloud.bean.CurrencyConversionBean;

/**
 * CurrencyConversionFeignProxy
 * 
 * @FeignClient(name = "currency-exchange-service", url = "http://localhost:8000") 
 * 		- Used when you have to hit the rest service directly with Get Mapping ahveing rest of the URI
 * 
 * @RibbonClient(name = "currency-exchange-service") 
 * 		- Used to tell Ribbon the client side application to which we need to hit
 * 		- URLs will be mapped in Properties file
 * 
 * @FeignClient(name = "zuul-api-gateway")
 * 		- Uses the ZUUL API Gateway name registered in Eureka Naming Server to get the corresponding Rest serv
 * 		- Method name needs to be changed to have service name as well
 * 
 * @author girishgowda
 *
 */
//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyConversionFeignProxy {
	
	/*
	 * This method signature is fetched and is exactly same as the Rest service which is providing this.
	 * 
	 */
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getConversionRate(@PathVariable("from") String from, @PathVariable("to") String to);
	
}
