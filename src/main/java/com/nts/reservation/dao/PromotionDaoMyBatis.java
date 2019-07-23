package com.nts.reservation.dao;

import java.util.List;

import com.nts.reservation.dto.database.Promotion;

public interface PromotionDaoMyBatis {
	List<Promotion> getPromotionList();
}
