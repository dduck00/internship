package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.PromotionDao;
import com.nts.reservation.dto.PromotionsInfo;
import com.nts.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	private final PromotionDao PROMOTION_DAO;

	@Autowired
	public PromotionServiceImpl(PromotionDao promotionDao) {
		this.PROMOTION_DAO = promotionDao;
	}

	@Override
	public PromotionsInfo getPromotionsInfo() {
		PromotionsInfo promotionsInfo = new PromotionsInfo();
		promotionsInfo.setItems(PROMOTION_DAO.selectPromotionList());
		return promotionsInfo;
	}

}
