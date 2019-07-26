package com.nts.reservation.dao;

import java.util.List;

import com.nts.reservation.dto.Category;

public interface CategoryDao {
	List<Category> selectCategoryList();

	int selectCategoryCount();
}