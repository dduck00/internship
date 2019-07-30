package com.nts.reservation.mainpage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.mainpage.dto.Product;

@Repository
public interface ProductDao {
	List<Product> selectProductList(@Param("id") int categoryId, @Param("start") int start, @Param("limit") int limit);

	int selectProductCount(@Param("id") int categoryId);
}