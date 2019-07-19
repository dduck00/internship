package com.nts.reservation.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api", produces = "text/json; charset=UTF-8")
public class PromotionJSONResponseService {

	PromotionService promotionService;

	@Autowired
	public PromotionJSONResponseService(PromotionService promotionService) {
		this.promotionService = promotionService;

	}

	@GetMapping("/promotions")
	public String getPromotions() {
		return "{\"items\": " + promotionService.getPromotionList() + "}";
	}

}
