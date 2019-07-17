package com.nts.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.nts.guestbook.dao", "com.nts.guestbook.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}