package com.nts.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

	@Value("${jdbc.DRIVER_CLASSNAME}")
	private String DRIVER_CLASSNAME;

	@Value("${jdbc.URL}")
	private String URL;

	@Value("${jdbc.USERNAME}")
	private String USERNAME;

	@Value("${jdbc.PASSWORD}")
	private String PASSWORD;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_CLASSNAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

}