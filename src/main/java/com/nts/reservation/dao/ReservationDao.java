package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.dto.ReservationInfoPrice;

@Repository
public interface ReservationDao {
	int insertReservationInfo(ReservationInfo reservationInfo);

	int insertReservationInfoPrice(@Param("reservationInfoId") int reservationInfoId,
		@Param("priceInfoList") List<ReservationInfoPrice> reservationInfoPrice);

	List<ReservationInfo> selectReservationList(String email);

	void updateReservationCancel(@Param("id") int id, @Param("email") String email);

}
