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

	@Autowired
	PromotionService promotionService;

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/promotions")
	public String getPromotion() {
		String promotionJSON = "{\"items\": " + promotionService.getPromotionList() + "}";

		return promotionJSON;
	}

	@GetMapping("/categories")
	public String getCategories() {
		String promotionJSON = "{\"items\": " + categoryService.getCategoryData() + "}";

		return promotionJSON;
	}

	@GetMapping("/products")
	public String getProducts(@RequestParam(name = "categoryId", required = false, defaultValue = "-1") int categoryId,
		@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		String productJSON = "{\"totalCount\": " + productService.getCount(categoryId) + ",\"items\": "
			+ productService.getProductList(categoryId, start)
			+ "}";

		return productJSON;
	}
}
