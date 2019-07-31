package com.nts.reservation.service;

import com.nts.reservation.dto.ProductsInfo;

public interface ProductService {
	int getProductCount(int category);

	ProductsInfo getProductsInfo(int categoryId, int startProductIndex);
}