package com.nts.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({IllegalArgumentException.class})
	public void illegalArgumentHandler() {}
}
