package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.dto.ProductImage;
import com.nts.reservation.dto.Promotion;
import com.nts.reservation.service.PromotionService;

public class PromotionServiceImp implements PromotionService {
	@Autowired
	PromotionDao promotionDao;

	@Override
	@Transactional
	public String getPromotionList() {
		List<FileInfo> fileInfo = promotionDao.selectProductFileInfo();
		List<ProductImage> productImage = promotionDao.selectPromotionImage();
		List<Promotion> promotion = promotionDao.selectPromotion();

		JSONArray promotionData = new JSONArray();

		for (int indexOfPromotion = 0; indexOfPromotion < promotion.size(); indexOfPromotion++) {
			JSONObject tempJson = new JSONObject();
			tempJson.put("id", promotion.get(indexOfPromotion).getId());
			tempJson.put("productId", productImage.get(indexOfPromotion).getProductId());
			tempJson.put("id", fileInfo.get(indexOfPromotion).getFileName());

			promotionData.add(tempJson);
		}
		return promotionData.toJSONString();
	}

}
