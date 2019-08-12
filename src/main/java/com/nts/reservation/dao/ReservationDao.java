package com.nts.reservation.dao;

import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.dto.ReservationInfoPrice;

@Repository
public interface ReservationDao {
	int insertReservationInfo(ReservationInfo reservationInfo);

	int insertReservationInfoPrice(ReservationInfoPrice reservationInfoPrice);

}
