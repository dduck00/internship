package com.nts.reservation.service.impl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.Product;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	@Transactional
	public int getCount(int category) {
		if (category == -1) {
			return productDao.selectProductCount();
		}
		return productDao.selectProductCategoryCount(category);
	}

	@Override
	@Transactional
	public String getProductList(int category, int start) {
		List<Product> products = null;

		JSONArray productData = new JSONArray();

		if (category == -1) {
			products = productDao.selectProductAll(start, start + LIMIT);
		} else {
			products = productDao.selectProductCategory(category, start, start + LIMIT);
		}

		for (Product product : products) {
			JSONObject tempJson = new JSONObject();

			tempJson.put("displayInfoId", product.getDisplayInfoId());
			tempJson.put("productId", product.getProductId());
			tempJson.put("productDescription", product.getProductDescription());
			tempJson.put("placeName", product.getPlaceName());
			tempJson.put("productContent", product.getProductContent());
			tempJson.put("productImageUrl", product.getProductImageUrl());

			productData.add(tempJson);
		}
		return productData.toJSONString();
	}

}
