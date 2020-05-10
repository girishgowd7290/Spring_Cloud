package com.codemads.springcloud.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 
 * Configuration : This class uses @Component to get it identified with Spring Container
 * @ConfigurationProperties("<microServcei_name>") - used to pull the properties file values
 * 
 * @author girishgowda
 *
 */
@Component
@ConfigurationProperties("limit-service")
public class Configuration {

	private String minimum;
	private String maximum;
	
	
	public String getMinimum() {
		return minimum;
	}
	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}
	public String getMaximum() {
		return maximum;
	}
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}
	
	
}
