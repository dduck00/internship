package com.nts.reservation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.dto.ReservationInfoPrice;

@Repository
public interface ReservationDao {
	int insertReservationInfo(ReservationInfo reservationInfo);

	int insertReservationInfoPrice(ReservationInfoPrice reservationInfoPrice);

	List<ReservationInfo> selectReservationList(String email);
}
