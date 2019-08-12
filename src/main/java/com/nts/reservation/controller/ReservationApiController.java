package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.ReservationInfoList;
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
	public ReservationInfoList responseResevationInfoList(
		@CookieValue(value = "email", required = true) String email) {
		return reservationService.getReservationList(email);
	}
}
