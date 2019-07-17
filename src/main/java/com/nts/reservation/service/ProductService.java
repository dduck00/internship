package com.nts.reservation.service;

public interface ProductService {
	public static final int LIMIT = 4;

	public int getCount(int category);

	public String getProductList(int category, int start);
}
