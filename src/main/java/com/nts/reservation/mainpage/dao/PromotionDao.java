package com.nts.reservation.mainpage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nts.reservation.mainpage.dto.Promotion;

@Repository
public interface PromotionDao {
	List<Promotion> selectPromotionList();
}
