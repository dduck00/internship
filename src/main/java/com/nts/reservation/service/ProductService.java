package com.nts.reservation.service;

import com.nts.reservation.dto.response.ProductJSON;

public interface ProductService {
	int getProductCount(int category);

	ProductJSON getProductJSON(int category, int start);
}
