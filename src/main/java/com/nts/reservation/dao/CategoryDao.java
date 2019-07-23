package com.nts.reservation.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.database.Category;

@Repository
public class CategoryDao {

	private static final String SELECT_CATEGORY_LIST = "SELECT category_id AS id, category.name AS name,count(*) AS count "
		+ "FROM product INNER JOIN category "
		+ "ON category.id = product.category_id "
		+ "GROUP BY category_id;";

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapperCategory = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public List<Category> getCategoryList() {
		return jdbc.query(SELECT_CATEGORY_LIST, rowMapperCategory);
	}

}
