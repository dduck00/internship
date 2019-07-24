package com.nts.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

	@GetMapping(path = "/product-detail")
	public String productDetailPage() {
		return "detail";
	}

	@GetMapping(path = "/booking-login")
	public String bookingLoginPage() {
		return "bookinglogin";
	}

	@GetMapping(path = "/main-page")
	public String mainPage() {
		return "mainpage";
	}

}
