package com.nts.reservation.service.impl;

import java.util.List;

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
	public List<Product> getProductList(int category, int start) {
		if (category <= 0) {
			return productDao.getProductList(start, LIMIT);
		}

		return productDao.getProductListByCategory(category, start, LIMIT);

	}

}
