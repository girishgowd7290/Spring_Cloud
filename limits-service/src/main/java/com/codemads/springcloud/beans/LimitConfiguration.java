/**
 * 
 */
package com.codemads.springcloud.beans;

/**
 * 
 * LimitConfiguration Bean class 
 * 
 * @author girishgowda
 *
 */
public class LimitConfiguration {

	private String minimum;
	private String maximum;
	public LimitConfiguration(String maximum, String minimum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public LimitConfiguration() {
	}
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
