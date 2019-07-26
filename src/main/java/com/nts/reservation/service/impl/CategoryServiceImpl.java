package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dto.CategorysInfo;
import com.nts.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public CategorysInfo getCategorysInfo() {
		CategorysInfo categoryMap = new CategorysInfo();
		categoryMap.setItems(categoryDao.selectCategoryList());
		return categoryMap;
	}

}