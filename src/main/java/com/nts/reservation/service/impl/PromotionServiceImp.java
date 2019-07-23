package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.PromotionDaoMyBatis;
import com.nts.reservation.dto.response.PromotionJSON;
import com.nts.reservation.service.PromotionService;

@Service
public class PromotionServiceImp implements PromotionService {

	private PromotionDaoMyBatis promotionDao;

	@Autowired
	public PromotionServiceImp(PromotionDaoMyBatis promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	public PromotionJSON getPromotionJSON() {
		PromotionJSON promotionResponseData = new PromotionJSON();
		promotionResponseData.setItems(promotionDao.getPromotionList());
		return promotionResponseData;
	}

}
