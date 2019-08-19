package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	private ReservationService reservationService;

	@Autowired
	public ReservationApiController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@PutMapping("/reservation")
	public int cancelReservation(@RequestBody int id,
		@CookieValue(value = "email") String email) {
		return reservationService.cancelReservation(id, email);
	}
}
