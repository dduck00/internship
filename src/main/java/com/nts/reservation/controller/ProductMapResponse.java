package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.response.ProductMap;
import com.nts.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class ProductMapResponse {

	private ProductService productService;

	@Autowired
	public ProductMapResponse(ProductService productService) {
		this.productService = productService;

	}

	@GetMapping("/products")
	public ProductMap responseProductMap(
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
		@RequestParam(name = "start", required = false, defaultValue = "0") int startIndex) {

		return productService.getProductMap(categoryId, startIndex);
	}

}
