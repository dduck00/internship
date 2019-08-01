package com.nts.reservation.service;

import java.util.List;

import com.nts.reservation.dto.Comment;

public interface CommentService {
	List<Comment> getCommentList(int productId);

	double getCommentAverage(int productId);
}
