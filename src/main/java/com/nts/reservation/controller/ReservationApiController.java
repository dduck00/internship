package com.nts.reservation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	private ReservationService reservationService;

	@Autowired
	public ReservationApiController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping("/reservations")
	public Map<String, List<ReservationInfo>> responseReservationInfoList(
		@CookieValue(value = "email") String email) {
		return reservationService.getReservationMap(email);
	}

	@GetMapping("/reservation/{id}")
	public void cancelReservation(@PathVariable int id,
		@CookieValue(value = "email") String email) {
		reservationService.cancelReservation(id, email);
	}
}
