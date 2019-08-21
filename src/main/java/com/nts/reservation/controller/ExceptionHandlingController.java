package com.nts.reservation.controller;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({DataRetrievalFailureException.class})
	public void dataRetrievalFailureExceptionHandler(DataRetrievalFailureException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({NumberFormatException.class, IllegalArgumentException.class})
	public String numberFormatHandler(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		return "error";
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({FileUploadException.class})
	public String fileUploadException(FileUploadException exception) {
		LOGGER.error(exception.getMessage(), exception);
		return "error";
	}
}
