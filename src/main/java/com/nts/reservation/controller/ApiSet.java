package com.nts.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api")
public class ApiSet {

	@Autowired
	ReservationService reservationService;

	@GetMapping("/promotions")
	public Map<String, String> getPromotion() {
		Map<String, String> promotionJSON = new HashMap<>();

		return promotionJSON;
	}
}
