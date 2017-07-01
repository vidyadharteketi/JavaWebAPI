package com.reporting.webapi.util;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

public class DemoJerseyLoadingUtil extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/
	@SuppressWarnings("unchecked")
	public DemoJerseyLoadingUtil(){
		//System.out.println("hi");
		/*register(RequestContextFilter.class);
		register(RestServiceUsingJersey.class);
		register(ServiceYearImpl.class);
		register(YearDaoImpl.class);
		register(JacksonFeature.class);*/
		
		/**
		 * Register JAX-RS application components.
		 */
		packages("com.reporting.webapi");

		// register features
		EncodingFilter.enableFor(this, GZipEncoder.class);
			
	     		
			
	

	}
}