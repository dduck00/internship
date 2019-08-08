package com.nts.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

	@GetMapping("/product-detail")
	public String productDetail(Model model, @RequestParam(defaultValue = "0") int id) {
		model.addAttribute("displayId", id);
		return "detail";
	}

	@GetMapping("/product-review")
	public String productReview(Model model, @RequestParam(defaultValue = "0") int id) {
		model.addAttribute("productId", id);
		return "review";
	}

	@GetMapping("/booking-login")
	public String bookingLogin() {
		return "bookinglogin";
	}

	@GetMapping("/main-page")
	public String mainPage() {
		return "mainpage";
	}

}