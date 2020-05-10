/**
 * 
 */
package com.codemads.springcloud.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codemads.springcloud.bean.CurrencyConversionBean;

/**
 * 
 * CurrencyConversionController 
 * @author girishgowda
 *
 */
@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Hard coded
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvetedAmount(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		return new CurrencyConversionBean(1000L, from, to, new BigDecimal(65), quantity, new BigDecimal(65), 8000);
	}

	// Call Currency Exchange Services using Rest Template
	@GetMapping("/currency-converter-rest/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvetedAmountRestTemplate(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		// map uri variables
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		//Rest Template call
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		
		// Get response Entity to Bean
		CurrencyConversionBean response = responseEntity.getBody();
		
		return new CurrencyConversionBean(
				response.getId(), from, to, response.getConversionMultiple(),
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	
	@Autowired
	private CurrencyConversionFeignProxy currencyConversionFeignProxy;
	
	/**
	 * Call Currency Exchange Services using Feign
	 * 
	 * Key Points: 
	 * 
	 * 1. Add new dependency for Feign
	 * 2. Add @enableFeignClients("packages")
	 * 3. Create aFeign client proxy calss with annotation and service name and uris
	 * 
	 * features: 
	 * 1. Integrates with Ribbon
	 * 2. Invoking other microservices
	 * 
	 * 
	 * @param from
	 * @param to
	 * @param quantity
	 * @return
	 */
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvetedAmountFEIGN(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = currencyConversionFeignProxy.getConversionRate(from, to);
		
		logger.info("response ::" + response);
		
		return new CurrencyConversionBean(
				response.getId(), from, to, response.getConversionMultiple(),
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
