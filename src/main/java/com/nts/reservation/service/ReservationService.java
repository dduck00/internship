package com.nts.reservation.service;

import java.util.List;
import java.util.Map;

import com.nts.reservation.dto.ReservationInfo;

public interface ReservationService {
	void addReservation(ReservationInfo reservationInfo);

	void updateReservation(Map<String, String[]> requestMap);

	Map<String, List<ReservationInfo>> getReservationMap(String email);
}
