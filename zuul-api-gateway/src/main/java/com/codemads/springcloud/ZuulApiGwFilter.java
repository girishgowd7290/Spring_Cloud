/**
 * 
 */
package com.codemads.springcloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Walks you through the process of routing and filtering requests to a microservice application by using the Netflix Zuul edge service library.
 * 
 * 
 * ZuulApiGwFilter extends ZuulFilter to filter the requests used by micreoservices
 * @author girishgowda
 *
 */
@Component
public class ZuulApiGwFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", 
				request, request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
}

