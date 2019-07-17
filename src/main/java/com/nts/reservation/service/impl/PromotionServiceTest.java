package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nts.reservation.config.ApplicationConfig;
import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.Promotion;

public class PromotionServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PromotionDao promotionDao = ac.getBean(PromotionDao.class);

		List<Promotion> promotions = promotionDao.selectPromotion();

		JSONArray promotionData = new JSONArray();

		for (Promotion promotion : promotions) {
			JSONObject tempJson = new JSONObject();

			tempJson.put("id", promotion.getId());
			tempJson.put("productId", promotion.getProductId());
			tempJson.put("productImageUrl", promotion.getProductImageUrl());

			promotionData.add(tempJson);
		}
		System.out.println(promotionData.toJSONString());
	}

}
