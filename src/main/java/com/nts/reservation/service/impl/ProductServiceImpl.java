package com.nts.reservation.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.response.ProductJSON;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final int LIMIT = 4;
	private ProductDao productDao;
	private CategoryDao categoryDao;
	private Logger logger;

	@Autowired
	public ProductServiceImpl(ProductDao productDao, CategoryDao categoryDao, Logger logger) {
		this.productDao = productDao;
		this.categoryDao = categoryDao;
		this.logger = logger;
	}

	@Override
	public int getCount(int category) {

		if (isCorrectCategory(category) == false) {
			logger.error("잘못된 카테고리 값을 요청하였습니다.");
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

		if (isCorrectCategory(category) == false) {
			logger.error("잘못된 카테고리 값을 요청하였습니다.");
			productResponse.setItems(productDao.selectProductList(start, LIMIT));
		} else {

			if (category == 0) {
				productResponse.setItems(productDao.selectProductList(start, LIMIT));
			} else {
				productResponse.setItems(productDao.selectProductListByCategory(category, start, LIMIT));
			}

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
