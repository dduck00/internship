package com.nts.reservation.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CategoryDao;
import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.response.ProductSet;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static final int COUNT_OF_PRODUCT_AT_ONCE = 4;

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
	public int getProductCount(int category) {

		if (isCorrectCategory(category) == false || category == 0) {
			return productDao.selectProductCount();
		}

		return productDao.selectCategoryProductCount(category);
	}

	@Override
	public ProductSet getProductSet(int categoryId, int start) {

		ProductSet productSet = new ProductSet();

		if (isCorrectCategory(categoryId) == false || categoryId == 0) {
			productSet.setItems(productDao.selectProductList(start, COUNT_OF_PRODUCT_AT_ONCE));
		} else {
			productSet
				.setItems(productDao.selectCategoryProductList(categoryId, start, COUNT_OF_PRODUCT_AT_ONCE));
		}
		productSet.setTotalCount(getProductCount(categoryId));
		return productSet;

	}

	private boolean isCorrectCategory(int category) {
		int categoryCount = categoryDao.selectCategoryList().size();

		if (0 <= category && category <= categoryCount) {
			return true;
		}
		logger.error("잘못된 카테고리 값을 요청하였습니다.");
		return false;
	}
}
