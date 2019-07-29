package com.nts.reservation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.Category;

@Repository
public interface CategoryDao {
	List<Category> selectCategoryList();

	int selectCategoryCount();
}