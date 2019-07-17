package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class ApiSet {

	@Autowired
	PromotionService promotionService;

	@GetMapping("/promotions")
	public String getPromotion() {
		String promotionJSON = promotionService.getPromotionList();

		return promotionJSON;
	}
}
