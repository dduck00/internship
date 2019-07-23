package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nts.reservation.dto.database.Product;

public interface ProductDao {
	List<Product> selectProductList(@Param("start") int start, @Param("limit") int limit);

	List<Product> selectProductListByCategory(@Param("id") int id, @Param("start") int start,
		@Param("limit") int limit);

	int selectProductCount();

	int selectProductCountByCategory(int id);
}
