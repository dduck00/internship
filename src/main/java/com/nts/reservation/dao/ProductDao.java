package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nts.reservation.dto.Product;

public interface ProductDao {
	List<Product> selectProductList(@Param("id") int categoryId, @Param("start") int start, @Param("limit") int limit);

	int selectProductCount(@Param("id") int categoryId);
}