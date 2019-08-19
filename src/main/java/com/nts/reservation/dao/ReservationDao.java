package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.ReservationInfo;

@Repository
public interface ReservationDao {
	int insertReservationInfo(ReservationInfo reservationInfo);

	int insertReservationInfoPrice(ReservationInfo reservationInfo);

	List<ReservationInfo> selectReservationList(String email);

	int updateReservationCancel(@Param("id") int id, @Param("email") String email);

}
