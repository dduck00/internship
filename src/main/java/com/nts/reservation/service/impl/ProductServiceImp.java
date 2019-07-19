package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.Product;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	ProductDao productDao;

	@Autowired
	public ProductServiceImp(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public int getCount(int category) {
		if (category == 0) {
			return productDao.getProductCount();
		}
		return productDao.getProductByCategoryCount(category);
	}

	@Override
	public String getProductList(int category, int start) {
		List<Product> products = null;

		JSONArray productJSONS = new JSONArray();

		if (category == 0) {
			products = productDao.getProductList(start, LIMIT);
		} else {
			products = productDao.getProductListByCategory(category, start, LIMIT);
		}

		for (Product product : products) {
			JSONObject productJSON = new JSONObject();

			productJSON.put("displayInfoId", product.getDisplayInfoId());
			productJSON.put("productId", product.getProductId());
			productJSON.put("productDescription", product.getProductDescription());
			productJSON.put("placeName", product.getPlaceName());
			productJSON.put("productContent", product.getProductContent());
			productJSON.put("productImageUrl", product.getProductImageUrl());

			productJSONS.add(productJSON);
		}
		return productJSONS.toJSONString();
	}

}
