package com.nts.reservation.dao;

public class ServiceSqls {

	static final String SELECT_PROMOTION = "SELECT promotion.id AS id, product_image.product_id AS product_id, file_info.save_file_name AS product_image_url FROM promotion INNER JOIN product_image INNER JOIN file_info ON promotion.product_id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th'";

	static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product;";
	static final String SELECT_PRODUCT_ALL = "SELECT * FROM product limit :start, :end";
	static final String SELECT_PRODUCT_CATEGORY = "SELECT * FROM product WHERE category_id = :id limit :start, :end;";
	static final String SELECT_COUNT_CATEGORY = "SELECT count(*) FROM product WHERE category_id = :id limit :start, :end;";
}
