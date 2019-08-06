package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.ProductsInfo;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static final int MAX_PRODUCT_SHOW_COUNT = 4;

	private final ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public int getProductCount(int categoryId) {
		return productDao.selectProductCount(categoryId);
	}

	@Override
	public ProductsInfo getProductsInfo(int categoryId, int startProductIndex) {

		ProductsInfo productsInfo = new ProductsInfo();

		if (isValidCategory(categoryId) == false) {
			throw new IllegalArgumentException("wrong category id");
		}

		productsInfo.setItems(productDao.selectProductList(categoryId, startProductIndex, MAX_PRODUCT_SHOW_COUNT));
		productsInfo.setTotalCount(getProductCount(categoryId));

		return productsInfo;
	}

	private boolean isValidCategory(int categoryId) {
		return categoryId >= 0;
	}
}