package com.nts.reservation.controller.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.database.Category;
import com.nts.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class CategoryJSONResponseService {

	CategoryService categoryService;

	@Autowired
	public CategoryJSONResponseService(CategoryService categoryService) {
		this.categoryService = categoryService;

	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getCategoryData();
	}

}
