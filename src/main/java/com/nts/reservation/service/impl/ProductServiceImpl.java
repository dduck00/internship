package com.nts.reservation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.ProductDao;
import com.nts.reservation.dto.ProductsInfo;
import com.nts.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static final int MAX_PRODUCT_SHOW_COUNT = 4;
	private static final int DEFAULT_CATEGORY = 0;

	private final ProductDao PRODUCT_DAO;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.PRODUCT_DAO = productDao;
	}

	@Override
	public int getProductCount(int categoryId) {
		return PRODUCT_DAO.selectProductCount(getValidCategory(categoryId));
	}

	@Override
	public ProductsInfo getProductsInfo(int categoryId, int startProductIndex) {

		ProductsInfo productsInfo = new ProductsInfo();

		categoryId = getValidCategory(categoryId);

		productsInfo.setItems(PRODUCT_DAO.selectProductList(categoryId, startProductIndex, MAX_PRODUCT_SHOW_COUNT));
		productsInfo.setTotalCount(getProductCount(categoryId));

		return productsInfo;
	}

	private int getValidCategory(int categoryId) {

		if (categoryId >= 0) {
			return categoryId;
		}

		LOGGER.error("잘못된 카테고리 값을 요청하였습니다.");

		return DEFAULT_CATEGORY;
	}
}