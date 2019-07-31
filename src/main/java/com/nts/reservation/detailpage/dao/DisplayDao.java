package com.nts.reservation.detailpage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.detailpage.dto.DisplayInfo;
import com.nts.reservation.detailpage.dto.DisplayInfoImage;
import com.nts.reservation.detailpage.dto.ProductImage;
import com.nts.reservation.detailpage.dto.ProductPrice;

@Repository
public interface DisplayDao {

	DisplayInfo selectDisplayInfo(@Param("id") int displayId);

	DisplayInfoImage selectDisplayInfoImage(@Param("id") int displayId);

	List<ProductPrice> selectProductPriceList(@Param("id") int productId);

	List<ProductImage> selectProductImageList(@Param("id") int productId);

	double selectProductAverage(@Param("id") int productId);
}
