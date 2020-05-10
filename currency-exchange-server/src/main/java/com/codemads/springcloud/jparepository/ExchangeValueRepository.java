package com.codemads.springcloud.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemads.springcloud.beans.ExchangeValue;

/**
 * ExchangeValueRepository extends JpaRepository<Bean name, Pvt key data type>
 * @Repository - used to enable JPA Features
 * 
 * @author girishgowda
 *
 */
@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	//Custom method to fetch values
	ExchangeValue findByFromAndTo(String from, String to);
}
