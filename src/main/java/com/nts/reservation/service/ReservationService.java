package com.nts.reservation.service;

import java.util.Map;

import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.dto.ReservationInfoList;

public interface ReservationService {
	void addReservation(ReservationInfo reservationInfo);

	void updateReservation(Map<String, String[]> requestMap);

	ReservationInfoList getReservationList(String email);
}
