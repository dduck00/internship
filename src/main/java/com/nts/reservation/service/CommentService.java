package com.nts.reservation.service;

import java.util.List;

import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.CommentList;

public interface CommentService {

	CommentList getCommentList(int productId);

	List<CommentInfo> getCommentInfoList(int productId, boolean isDetailPage);

	double getCommentAverage(List<CommentInfo> commentList);
}
