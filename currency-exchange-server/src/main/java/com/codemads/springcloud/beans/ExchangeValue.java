package com.codemads.springcloud.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ExchangeValue : A Bean mapped with a Table using @Entity Annotation
 * @author girishgowda
 *
 */
@Entity(name="exchange_value")
public class ExchangeValue {

	// Makes the pvt key
	@Id
	private Long id;
	
	// Describes the column name(uses Underscore between words)
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	@Column(name="conversion_multiple")
	private BigDecimal conversionMultiple;
	
	@Column(name="port")
	private Long port;
	
	// Mandatory for use with JPA
	public ExchangeValue() {
	}
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple, Long port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public Long getPort() {
		return port;
	}
	public void setPort(Long port) {
		this.port = port;
	}
}
