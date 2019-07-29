package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.Product;

@Repository
public interface ProductDao {
	List<Product> selectProductList(@Param("id") int categoryId, @Param("start") int start, @Param("limit") int limit);

	int selectProductCount(@Param("id") int categoryId);
}