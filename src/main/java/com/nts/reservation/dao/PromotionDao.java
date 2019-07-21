package com.nts.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.database.Promotion;

@Repository
public class PromotionDao {

	static final private String SELECT_PROMOTION = "SELECT promotion.id AS id, product_image.product_id AS product_id, file_info.save_file_name AS product_image_url "
		+ "FROM promotion INNER JOIN product_image INNER JOIN file_info "
		+ "ON promotion.product_id = product_image.product_id AND product_image.file_id = file_info.id AND product_image.type = 'th'";

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotion> rowMapperPromotion = BeanPropertyRowMapper.newInstance(Promotion.class);

	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Promotion> getPromotionList() {
		return jdbc.query(SELECT_PROMOTION, rowMapperPromotion);
	}

}
