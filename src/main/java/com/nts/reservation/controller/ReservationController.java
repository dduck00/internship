package com.nts.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
	@GetMapping(path = "/detail")
	public String list() {
		return "detail";
	}

	@GetMapping(path = "/bookinglogin")
	public String bookingLogin() {
		return "bookinglogin";
	}

	@GetMapping(path = "/mainpage")
	public String mainPage() {
		return "mainpage";
	}
}
