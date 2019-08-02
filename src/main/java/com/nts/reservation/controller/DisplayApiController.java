package com.nts.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.Display;
import com.nts.reservation.service.DisplayService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class DisplayApiController {

	private final DisplayService displayService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public DisplayApiController(DisplayService displayService) {
		this.displayService = displayService;
	}

	@GetMapping("/products/{displayId}")
	public Display responseDisplay(@PathVariable String displayId) {
		try {
			return displayService.getDisplay(Integer.parseInt(displayId));
		} catch (NumberFormatException e) {
			logger.error("잘못된 디스플레이아이디가 들어왔습니다. ** " + displayId);
			return null;
		}
	}
}
