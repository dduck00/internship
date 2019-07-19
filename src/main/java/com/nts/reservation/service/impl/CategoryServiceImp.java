package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	public String getCategoryData() {
		List<Category> categorys = categoryDao.selectCategoryAll();
		JSONArray categoryJSONS = new JSONArray();

		for (Category category : categorys) {
			JSONObject categoryJSON = new JSONObject();

			categoryJSON.put("id", category.getId());
			categoryJSON.put("name", category.getName());
			categoryJSON.put("count", category.getCount());

			categoryJSONS.add(categoryJSON);
		}

		return categoryJSONS.toJSONString();
	}

}
