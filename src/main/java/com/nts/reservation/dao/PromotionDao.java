package com.nts.reservation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.Promotion;

@Repository
public interface PromotionDao {
	List<Promotion> selectPromotionList();
}
