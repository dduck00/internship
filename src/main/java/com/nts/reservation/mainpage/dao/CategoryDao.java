package com.nts.reservation.mainpage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nts.reservation.mainpage.dto.Category;

@Repository
public interface CategoryDao {
	List<Category> selectCategoryList();

	int selectCategoryCount();
}