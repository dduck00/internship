package com.nts.reservation.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CommentDao;
import com.nts.reservation.dto.Comment;
import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<CommentInfo> getCommentList(int productId) {
		return commentDao.selectCommentList(productId);
	}

	@Override
	public double getCommentAverage(List<CommentInfo> commentList) {
		//return commentList.stream().mapToInt(CommentInfo::getScore).average().orElse(0);
		return commentList.stream().collect(Collectors.averagingInt(CommentInfo::getScore));
	}

	@Override
	public Comment getComment(int productId) {

		if (isValidProductId(productId) == false) {
			throw new IllegalArgumentException("productId가 음수입니다.");
		}

		Comment comment = new Comment();

		comment.setProductDescription(commentDao.selectProductDescription(productId));
		comment.setComments(getCommentList(productId));
		comment.setAverageScore(getCommentAverage(comment.getComments()));

		return comment;
	}

	private boolean isValidProductId(int productId) {
		return (productId > 0);
	}

}