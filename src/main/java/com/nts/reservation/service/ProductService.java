package com.nts.reservation.service;

import com.nts.reservation.dto.response.ProductSet;

public interface ProductService {
	int getProductCount(int category);

	ProductSet getProductSet(int categoryId, int start);
}