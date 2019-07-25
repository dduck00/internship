package com.nts.reservation.service;

import com.nts.reservation.dto.response.ProductMap;

public interface ProductService {
	int getProductCount(int category);

	ProductMap getProductMap(int categoryId, int startProductIndex);
}