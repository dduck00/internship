package com.nts.reservation.dao;

import static com.nts.reservation.dao.PromotionSqls.*;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.dto.ProductImage;
import com.nts.reservation.dto.Promotion;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotion> rowMapperPromotion = BeanPropertyRowMapper.newInstance(Promotion.class);
	private RowMapper<ProductImage> rowMapperProductImage = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<FileInfo> rowMapperFileInfo = BeanPropertyRowMapper.newInstance(FileInfo.class);

	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Promotion> selectPromotion() {
		return jdbc.query(PROMOTION_SELECT_PROMOTION, rowMapperPromotion);
	}

	public List<ProductImage> selectPromotionImage() {
		return jdbc.query(PROMOTION_SELECT_PRODUCT_IMAGE, rowMapperProductImage);
	}

	public List<FileInfo> selectProductFileInfo() {
		return jdbc.query(PROMOTION_SELECT_PRODUCT_FILE_INFO, rowMapperFileInfo);
	}
}
