package com.nts.reservation.service;

import java.util.Map;

public interface ReservationService {
	void addReservation(Map<String, String[]> requestMap);

	void updateReservation(Map<String, String[]> requestMap);
}
