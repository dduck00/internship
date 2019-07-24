package com.nts.reservation.service;

import com.nts.reservation.dto.response.ProductJSON;

public interface ProductService {
	int getCount(int category);

	ProductJSON getProductJSON(int category, int start);
}
