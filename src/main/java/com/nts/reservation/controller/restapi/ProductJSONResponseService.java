package com.nts.reservation.controller.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.database.Product;
import com.nts.reservation.dto.response.ProductResponse;
import com.nts.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class ProductJSONResponseService {

	ProductService productService;

	@Autowired
	public ProductJSONResponseService(ProductService productService) {
		this.productService = productService;

	}

	@GetMapping("/products")
	public ProductResponse getProducts(
		@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
		@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setItems(productService.getProductList(categoryId, start));
		productResponse.setTotalCount(productService.getCount(categoryId));
		
		return productResponse;
	}
}
