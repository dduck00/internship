package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.Promotion;
import com.nts.reservation.service.PromotionService;

@Service
public class PromotionServiceImp implements PromotionService {

	PromotionDao promotionDao;

	@Autowired
	public PromotionServiceImp(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	public String getPromotionList() {

		List<Promotion> promotions = promotionDao.selectPromotion();

		JSONArray promotionJSONS = new JSONArray();

		for (Promotion promotion : promotions) {
			JSONObject promotionJSON = new JSONObject();

			promotionJSON.put("id", promotion.getId());
			promotionJSON.put("productId", promotion.getProductId());
			promotionJSON.put("productImageUrl", promotion.getProductImageUrl());

			promotionJSONS.add(promotionJSON);
		}
		return promotionJSONS.toJSONString();
	}

}
