package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dto.Category;
import com.nts.reservation.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	@Transactional
	public String getCategoryData() {
		List<Category> categorys = categoryDao.selectCategoryAll();
		JSONArray categoryData = new JSONArray();

		for (Category category : categorys) {
			JSONObject tempJson = new JSONObject();

			tempJson.put("id", category.getId());
			tempJson.put("name", category.getName());
			tempJson.put("count", category.getCount());

			categoryData.add(tempJson);
		}

		return categoryData.toJSONString();
	}

}
