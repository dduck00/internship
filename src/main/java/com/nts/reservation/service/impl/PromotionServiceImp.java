package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.Promotion;
import com.nts.reservation.service.PromotionService;

@Service
public class PromotionServiceImp implements PromotionService {
	@Autowired
	PromotionDao promotionDao;

	@Override
	@Transactional
	public String getPromotionList() {

		List<Promotion> promotions = promotionDao.selectPromotion();

		JSONArray promotionData = new JSONArray();

		for (Promotion promotion : promotions) {
			JSONObject tempJson = new JSONObject();

			tempJson.put("id", promotion.getId());
			tempJson.put("productId", promotion.getProductId());
			tempJson.put("productImageUrl", promotion.getProductImageUrl());

			promotionData.add(tempJson);
		}
		return promotionData.toJSONString();
	}

}
