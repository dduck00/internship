package com.nts.reservation.dao;

import static com.nts.reservation.dao.ServiceSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapperProduct = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> selectProductAll(int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_ALL, params, rowMapperProduct);
	}

	public int selectProductCount() {
		return jdbc.queryForObject(SELECT_PRODUCT_ALL_COUNT, Collections.emptyMap(), Integer.class);
	}

	public List<Product> selectProductCategory(int category, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", category);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_CATEGORY, params, rowMapperProduct);
	}

	public int selectProductCategoryCount(int category) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", category);
		return jdbc.queryForObject(SELECT_PRODUCT_CATEGORY_COUNT, params, Integer.class);
	}
}
