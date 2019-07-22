package com.nts.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.database.Product;

@Repository
public class ProductDao {

	private static final String SELECT_PRODUCT_LIST = "SELECT product.content AS product_content, file_info.save_file_name AS product_image_url, display_info.place_name AS place_name, product.description AS product_description, product.id AS product_id, display_info.id AS display_info_id "
		+ "FROM product INNER JOIN display_info INNER JOIN product_image INNER JOIN file_info "
		+ "ON product.id = display_info.product_id AND product.id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th' "
		+ "limit :start, :limit;";

	private static final String SELECT_PRODUCT_LIST_BY_CATEGORY = "SELECT product.content AS product_content, file_info.save_file_name AS product_image_url, display_info.place_name AS place_name, product.description AS product_description, product.id AS product_id, display_info.id AS display_info_id "
		+ "FROM product INNER JOIN display_info INNER JOIN product_image INNER JOIN file_info "
		+ "ON product.id = display_info.product_id AND product.id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th' AND product.category_id = :id "
		+ "limit :start, :limit;";

	private static final String SELECT_PRODUCT_LIST_COUNT = "SELECT COUNT(*) "
		+ "FROM product INNER JOIN display_info INNER JOIN product_image INNER JOIN file_info "
		+ "ON product.id = display_info.product_id AND product.id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th'";

	private static final String SELECT_PRODUCT_LIST_COUNT_BY_CATEGORY = "SELECT COUNT(*) "
		+ "FROM product INNER JOIN display_info INNER JOIN product_image INNER JOIN file_info "
		+ "ON product.id = display_info.product_id AND product.id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th' AND product.category_id = :id";

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapperProduct = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public List<Product> getProductList(int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_LIST, params, rowMapperProduct);
	}

	public int getProductCount() {
		return jdbc.queryForObject(SELECT_PRODUCT_LIST_COUNT, Collections.emptyMap(), Integer.class);
	}

	public List<Product> getProductListByCategory(int category, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", category);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_LIST_BY_CATEGORY, params, rowMapperProduct);
	}

	public int getProductCountByCategory(int category) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", category);
		return jdbc.queryForObject(SELECT_PRODUCT_LIST_COUNT_BY_CATEGORY, params, Integer.class);
	}

}
