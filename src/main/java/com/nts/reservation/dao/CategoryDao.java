package com.nts.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.database.Category;

@Repository
public class CategoryDao {

	static final private String SELECT_CATEGORY_DATA = "SELECT category_id AS id, category.name AS name,count(*) AS count "
		+ "FROM product INNER JOIN category "
		+ "ON category.id = product.category_id "
		+ "GROUP BY category_id;";

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapperCategory = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> getCategoryList() {
		return jdbc.query(SELECT_CATEGORY_DATA, rowMapperCategory);
	}
}
