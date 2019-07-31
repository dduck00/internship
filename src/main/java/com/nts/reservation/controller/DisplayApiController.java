package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.detailpage.dto.Display;
import com.nts.reservation.detailpage.service.DisplayService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class DisplayApiController {

	private final DisplayService displayService;

	@Autowired
	public DisplayApiController(DisplayService displayService) {
		this.displayService = displayService;
	}

	@GetMapping("/products/{displayId}")
	public Display responseDisplayDetail(@PathVariable String displayId) {
		return displayService.getDisplayDetail(Integer.parseInt(displayId));
	}
}
