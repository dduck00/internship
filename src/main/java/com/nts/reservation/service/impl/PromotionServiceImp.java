package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.response.PromotionJSON;
import com.nts.reservation.service.PromotionService;

@Service
public class PromotionServiceImp implements PromotionService {

	private PromotionDao promotionDao;

	@Autowired
	public PromotionServiceImp(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	public PromotionJSON getPromotionList() {
		PromotionJSON promotionResponseData = new PromotionJSON();
		promotionResponseData.setItems(promotionDao.getPromotionList());
		return promotionResponseData;
	}

}
