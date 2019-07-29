package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dto.CategorysInfo;
import com.nts.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao CATEGORY_DAO;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.CATEGORY_DAO = categoryDao;
	}

	@Override
	public CategorysInfo getCategorysInfo() {
		CategorysInfo categoryInfo = new CategorysInfo();
		categoryInfo.setItems(CATEGORY_DAO.selectCategoryList());
		return categoryInfo;
	}

}