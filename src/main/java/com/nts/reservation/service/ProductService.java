package com.nts.reservation.service;

import java.util.List;

import com.nts.reservation.dto.Product;

public interface ProductService {
	public static final int LIMIT = 4;

	public int getCount(int category);

	public List<Product> getProductList(int category, int start);
}
