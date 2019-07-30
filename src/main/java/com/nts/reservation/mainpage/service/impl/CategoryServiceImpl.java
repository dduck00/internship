package com.nts.reservation.mainpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.mainpage.dao.CategoryDao;
import com.nts.reservation.mainpage.dto.CategorysInfo;
import com.nts.reservation.mainpage.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public CategorysInfo getCategorysInfo() {
		CategorysInfo categoryInfo = new CategorysInfo();
		categoryInfo.setItems(categoryDao.selectCategoryList());
		return categoryInfo;
	}

}