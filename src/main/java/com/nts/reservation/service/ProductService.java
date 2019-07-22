package com.nts.reservation.service;

import com.nts.reservation.dto.response.ProductJSON;

public interface ProductService {
	public static final int LIMIT = 4;

	public int getCount(int category);

	public ProductJSON getProductList(int category, int start);
}
