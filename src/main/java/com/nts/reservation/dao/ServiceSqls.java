package com.nts.reservation.dao;

public class ServiceSqls {

	//promotion Serivce
	static final String SELECT_PROMOTION = "SELECT promotion.id AS id, product_image.product_id AS product_id, file_info.save_file_name AS product_image_url FROM promotion INNER JOIN product_image INNER JOIN file_info ON promotion.product_id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th'";

	//product Service
	static final String SELECT_PRODUCT_ALL = "SELECT product.content AS product_content, file_info.save_file_name AS product_image_url, display_info.place_name AS place_name, product.description AS product_description, product.id AS product_id, display_info.id AS display_info_id FROM product INNER JOIN display_info INNER JOIN display_info_image INNER JOIN file_info ON product.id = display_info.product_id AND display_info.id = display_info_image.display_info_id AND display_info_image.file_id = file_info.id  limit :start, :limit;";
	static final String SELECT_PRODUCT_CATEGORY = "SELECT product.content AS product_content, file_info.save_file_name AS product_image_url, display_info.place_name AS place_name, product.description AS product_description, product.id AS product_id, display_info.id AS display_info_id FROM product INNER JOIN display_info INNER JOIN display_info_image INNER JOIN file_info ON product.id = display_info.product_id AND display_info.id = display_info_image.display_info_id AND display_info_image.file_id = file_info.id AND product.category_id = 3 AND category_id = :id limit :start, :limit;";

	static final String SELECT_PRODUCT_ALL_COUNT = "SELECT COUNT(*) FROM product INNER JOIN display_info INNER JOIN display_info_image INNER JOIN file_info ON product.id = display_info.product_id AND display_info.id = display_info_image.display_info_id AND display_info_image.file_id = file_info.id;";
	static final String SELECT_PRODUCT_CATEGORY_COUNT = "SELECT COUNT(*) FROM product INNER JOIN display_info INNER JOIN display_info_image INNER JOIN file_info ON product.id = display_info.product_id AND display_info.id = display_info_image.display_info_id AND display_info_image.file_id = file_info.id AND product.category_id = 3 AND category_id = :id;";

	//Category Service
	static final String SELECT_CATEGORY_DATA = "SELECT category_id, category.name,count(*) FROM product INNER JOIN category ON category.id = product.category_id GROUP BY category_id;";
}
