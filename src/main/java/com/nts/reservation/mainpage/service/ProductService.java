package com.nts.reservation.mainpage.service;

import com.nts.reservation.mainpage.dto.ProductsInfo;

public interface ProductService {
	int getProductCount(int category);

	ProductsInfo getProductsInfo(int categoryId, int startProductIndex);
}