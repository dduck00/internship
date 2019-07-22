package com.nts.reservation.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.response.PromotionResponse;
import com.nts.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class PromotionJSONResponseService {

	PromotionService promotionService;

	@Autowired
	public PromotionJSONResponseService(PromotionService promotionService) {
		this.promotionService = promotionService;

	}

	@GetMapping("/promotions")
	public PromotionResponse getPromotions() {
		PromotionResponse promotionResponseData = new PromotionResponse();
		promotionResponseData.setItems(promotionService.getPromotionList());
		return promotionResponseData;
	}

}
