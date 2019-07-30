package com.nts.reservation.mainpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.mainpage.dao.PromotionDao;
import com.nts.reservation.mainpage.dto.PromotionsInfo;
import com.nts.reservation.mainpage.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	private final PromotionDao promotionDao;

	@Autowired
	public PromotionServiceImpl(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	public PromotionsInfo getPromotionsInfo() {
		PromotionsInfo promotionsInfo = new PromotionsInfo();
		promotionsInfo.setItems(promotionDao.selectPromotionList());
		return promotionsInfo;
	}

}
