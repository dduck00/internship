package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.detailpage.dto.DisplayDetail;
import com.nts.reservation.detailpage.service.DisplayService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class DisplayDetailApiController {

	private final DisplayService displayService;

	@Autowired
	public DisplayDetailApiController(DisplayService displayService) {
		this.displayService = displayService;
	}

	@GetMapping("/products/{displayId}")
	public DisplayDetail responseDisplayDetail(@PathVariable String displayId) {
		return displayService.getDisplayDetail(Integer.parseInt(displayId));
	}
}
