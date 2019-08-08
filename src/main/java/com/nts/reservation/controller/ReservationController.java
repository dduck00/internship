package com.nts.reservation.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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
	public String mainPage(Model model,
		@CookieValue(value = "email", required = false) String cookieEmail) {
		System.out.println(cookieEmail);
		if (cookieEmail == null) {
			cookieEmail = "예약확인";
		}
		model.addAttribute("userEmail", cookieEmail);
		return "mainpage";
	}

	@GetMapping("/myreservation")
	public String myReservation(Model model,
		HttpServletResponse response,
		@CookieValue(value = "email", required = false) String cookieEmail,
		@RequestParam(required = true) String resrv_email) {

		if (cookieEmail == null || resrv_email.equals(cookieEmail) == false) {
			Cookie cookie = new Cookie("email", resrv_email);
			cookie.setMaxAge(60 * 60 * 24 * 365);
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		return "myreservation";
	}

}