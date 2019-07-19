package com.nts.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dto.Category;
import com.nts.reservation.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

	CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImp(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getCategoryData() {
		return categoryDao.getCategoryList();
	}

}
