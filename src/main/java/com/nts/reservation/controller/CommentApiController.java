package com.nts.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dto.Comment;
import com.nts.reservation.service.CommentService;

@RestController
@RequestMapping(path = "/api", produces = "application/json; charset=UTF-8")
public class CommentApiController {

	private final CommentService commentService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CommentApiController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/comments/{productId}")
	public Comment responseComment(@PathVariable int productId) {
		return commentService.getComment(productId);
	}

}
