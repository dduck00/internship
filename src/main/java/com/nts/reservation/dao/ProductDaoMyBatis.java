package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nts.reservation.dto.database.Product;

public interface ProductDaoMyBatis {
	List<Product> getProductList(@Param("start") int start, @Param("limit") int limit);

	List<Product> getProductListByCategory(@Param("id") int id, @Param("start") int start, @Param("limit") int limit);

	int getProductCount();

	int getProductCountByCategory(int id);
}
