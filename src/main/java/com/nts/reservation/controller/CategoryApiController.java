package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.CategorysInfo;
import com.nts.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class CategoryApiController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryApiController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public CategorysInfo responseCategorysInfo() {
		return categoryService.getCategorysInfo();
	}

}
