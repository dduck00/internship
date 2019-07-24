package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dto.response.CategorySet;
import com.nts.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public CategorySet getCategorySet() {
		CategorySet categorySet = new CategorySet();
		categorySet.setItems(categoryDao.selectCategoryList());
		return categorySet;
	}

}
