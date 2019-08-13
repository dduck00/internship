package com.nts.reservation.service;

import java.util.Map;

import com.nts.reservation.dto.ReservationInfo;

public interface ReservationService {
	void addReservation(ReservationInfo reservationInfo);

	void updateReservation(Map<String, String[]> requestMap);

	Map<String, ReservationInfo> getReservationMap(String email);
}
