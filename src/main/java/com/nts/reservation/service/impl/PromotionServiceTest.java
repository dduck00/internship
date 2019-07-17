package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nts.reservation.config.ApplicationConfig;
import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.dto.ProductImage;
import com.nts.reservation.dto.Promotion;

public class PromotionServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PromotionDao promotionDao = ac.getBean(PromotionDao.class);

		List<FileInfo> fileInfo = promotionDao.selectProductFileInfo();
		List<ProductImage> productImage = promotionDao.selectPromotionImage();
		List<Promotion> promotion = promotionDao.selectPromotion();

		JSONArray promotionData = new JSONArray();

		for (int indexOfPromotion = 0; indexOfPromotion < promotion.size(); indexOfPromotion++) {
			JSONObject tempJson = new JSONObject();

			tempJson.put("id", promotion.get(indexOfPromotion).getId());
			tempJson.put("productId", productImage.get(indexOfPromotion).getProductId());
			tempJson.put("productImageUrl", fileInfo.get(indexOfPromotion).getFileName());

			promotionData.add(tempJson);
		}
		System.out.println(promotionData.toJSONString());
	}

}
