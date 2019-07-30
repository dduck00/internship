package com.nts.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

	@GetMapping(path = "/product-detail")
	public String productDetail(@RequestParam(name = "id", required = true) int productId) {
		return "detail";
	}

	@GetMapping(path = "/product-review")
	public String productReview() {
		return "review";
	}

	@GetMapping(path = "/booking-login")
	public String bookingLogin() {
		return "bookinglogin";
	}

	@GetMapping(path = "/main-page")
	public String mainPage() {
		return "mainpage";
	}

}