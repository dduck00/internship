package com.nts.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

	private final Logger loggerDisplayController = LoggerFactory.getLogger(DisplayApiController.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({IllegalArgumentException.class})
	public void illegalArgumentHandler(IllegalArgumentException exception) {}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({NumberFormatException.class})
	public void numberFormatHandler(NumberFormatException exception) {
		loggerDisplayController.error("문자열이 들어왔습니다!");
	}
}
