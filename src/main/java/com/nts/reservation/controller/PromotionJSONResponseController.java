package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.response.PromotionJSON;
import com.nts.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class PromotionJSONResponseController {

	private PromotionService promotionService;

	@Autowired
	public PromotionJSONResponseController(PromotionService promotionService) {
		this.promotionService = promotionService;

	}

	@GetMapping("/promotions")
	public PromotionJSON getPromotionJSON() {
		return promotionService.getPromotionList();
	}

}
