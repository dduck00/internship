package com.nts.reservation.service;

import com.nts.reservation.dto.response.ProductJSON;

public interface ProductService {
	static final int LIMIT = 4;

	int getCount(int category);

	ProductJSON getProductList(int category, int start);
}
