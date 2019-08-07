package com.nts.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({IllegalAccessError.class})
	public void illegalAccessErrorHandler(IllegalAccessError exception) {
		LOGGER.error(exception.getMessage(), exception);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({NumberFormatException.class, IllegalArgumentException.class})
	public void numberFormatHandler(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
	}

}
