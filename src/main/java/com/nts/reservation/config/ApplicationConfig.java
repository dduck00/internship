package com.nts.reservation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.nts.reservation"})
@PropertySource(value = {"classpath:/property/jdbc.properties"})
public class ApplicationConfig {

	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(this.getClass());
	}

}