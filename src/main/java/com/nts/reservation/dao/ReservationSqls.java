package com.nts.reservation.dao;

public class ReservationSqls {
	static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product;";
	static final String SELECT_PRODUCT_ALL = "SELECT * FROM product limit :start, :end";
	static final String SELECT_PRODUCT_CATEGORY = "SELECT * FROM product WHERE category_id = :id limit :start, :end;";
	static final String SELECT_COUNT_CATEGORY = "SELECT count(*) FROM product WHERE category_id = :id limit :start, :end;";
}
