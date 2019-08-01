package com.nts.reservation.service;

import java.util.List;

import com.nts.reservation.dto.CommentInfo;

public interface CommentService {
	List<CommentInfo> getCommentList(int productId);

	double getCommentAverage(int productId);
}
