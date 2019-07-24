package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.response.ProductJSON;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	private CategoryDao categoryDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao, CategoryDao categoryDao) {
		this.productDao = productDao;
		this.categoryDao = categoryDao;
	}

	@Override
	public int getCount(int category) {

		if (isCorrectCategory(category) == false) {
			return productDao.selectCountOfProductList();
		}

		if (category == 0) {
			return productDao.selectCountOfProductList();
		}

		return productDao.selectCountOfProductListByCategory(category);
	}

	@Override
	public ProductJSON getProductJSON(int category, int start) {

		ProductJSON productResponse = new ProductJSON();

		if (isCorrectCategory(category)) {
			productResponse.setItems(productDao.selectProductList(start, LIMIT));
		} else {
			productResponse.setItems(productDao.selectProductListByCategory(category, start, LIMIT));
		}

		productResponse.setTotalCount(getCount(category));
		return productResponse;

	}

	private boolean isCorrectCategory(int category) {
		int categoryCount = categoryDao.selectCategoryList().size();

		if (0 <= category && category <= categoryCount) {
			return true;
		}
		return false;
	}
}
