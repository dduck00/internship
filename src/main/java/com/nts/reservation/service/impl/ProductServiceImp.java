package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.ProductDaoMyBatis;
import com.nts.reservation.dto.response.ProductJSON;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	private ProductDaoMyBatis productDao;

	@Autowired
	public ProductServiceImp(ProductDaoMyBatis productDao) {
		this.productDao = productDao;
	}

	@Override
	public int getCount(int category) {
		if (category <= 0) {
			return productDao.getProductCount();
		}
		return productDao.getProductCountByCategory(category);
	}

	@Override
	public ProductJSON getProductJSON(int category, int start) {

		ProductJSON productResponse = new ProductJSON();

		if (category <= 0 || category > 5) {
			productResponse.setItems(productDao.getProductList(start, LIMIT));
		} else {
			productResponse.setItems(productDao.getProductListByCategory(category, start, LIMIT));
		}
		productResponse.setTotalCount(getCount(category));
		return productResponse;

	}

}
