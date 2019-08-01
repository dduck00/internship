package com.nts.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.CommentService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class CommentApiController {

	private final CommentService commentService;

	@Autowired
	public CommentApiController(CommentService commentService) {
		this.commentService = commentService;
	}

}
