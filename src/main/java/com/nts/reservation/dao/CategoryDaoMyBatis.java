package com.nts.reservation.dao;

import java.util.List;

import com.nts.reservation.dto.database.Category;

public interface CategoryDaoMyBatis {
	List<Category> getCategoryList();
}
