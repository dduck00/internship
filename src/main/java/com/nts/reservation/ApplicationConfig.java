package com.nts.reservation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource(value = {"classpath:properties/jdbc.properties"})
@Import({DBConfig.class})
public class ApplicationConfig {

}