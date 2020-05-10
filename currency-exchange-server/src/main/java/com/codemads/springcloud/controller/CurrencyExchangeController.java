/**
 * 
 */
package com.codemads.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codemads.springcloud.beans.ExchangeValue;
import com.codemads.springcloud.jparepository.ExchangeValueRepository;


/**
 * 
 * CurrencyExchangeController :  Controller class 
 * 
 * @RestController - Used to enable rest interface
 * @Autowired - To get the bean created
 * 
 * @author girishgowda
 *
 */
@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getConversionRate(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = new ExchangeValue();
		exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		
		logger.info("Exchange ::" + exchangeValue );
		exchangeValue.setPort(Long.valueOf(environment.getProperty("local.server.port")));
		
		return exchangeValue;
		//return new ExchangeValue(1000L, from, to, new BigDecimal(83), 8000L);
	}
}
