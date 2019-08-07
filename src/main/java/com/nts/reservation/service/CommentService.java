package com.nts.reservation.service;

import java.util.List;

import com.nts.reservation.dto.Comment;
import com.nts.reservation.dto.CommentInfo;

public interface CommentService {

	Comment getComment(int productId);

	List<CommentInfo> getCommentList(int productId);

	double getCommentAverage(List<CommentInfo> commentList);
}
