package com.nts.reservation.service.impl;

import java.util.List;

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
	public List<Promotion> getPromotionList() {
		return promotionDao.getPromotionList();
	}

}
