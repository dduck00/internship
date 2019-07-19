package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.CategoryService;
import com.nts.reservation.service.ProductService;
import com.nts.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api", produces = "text/json; charset=UTF-8")
public class ApiSet {

	PromotionService promotionService;
	ProductService productService;
	CategoryService categoryService;

	@Autowired
	public ApiSet(PromotionService promotionService,
		ProductService productService,
		CategoryService categoryService) {
		this.promotionService = promotionService;
		this.productService = productService;
		this.categoryService = categoryService;

	}

	@GetMapping("/promotions")
	public String getPromotions() {
		return "{\"items\": " + promotionService.getPromotionList() + "}";
	}

	@GetMapping("/categories")
	public String getCategories() {
		return "{\"items\": " + categoryService.getCategoryData() + "}";
	}

	@GetMapping("/products")
	public String getProducts(@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
		@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return "{\"totalCount\": "
			+ productService.getCount(categoryId)
			+ ",\"items\": "
			+ productService.getProductList(categoryId, start)
			+ "}";
	}
}
