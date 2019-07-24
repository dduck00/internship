package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.response.PromotionSet;
import com.nts.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	private PromotionDao promotionDao;

	@Autowired
	public PromotionServiceImpl(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	public PromotionSet getPromotionSet() {
		PromotionSet promotionResponseData = new PromotionSet();
		promotionResponseData.setItems(promotionDao.selectPromotionList());
		return promotionResponseData;
	}

}
