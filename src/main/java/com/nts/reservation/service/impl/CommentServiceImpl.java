package com.nts.reservation.service.impl;

import java.util.List;

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
	public double getCommentAverage(int productId) {
		return commentDao.selectCommentAverage(productId);
	}

	@Override
	public Comment getComment(int productId) {
		Comment comment = new Comment();

		if (isValidProductId(productId) == false) {
			return comment;
		}

		comment.setProductDescription(commentDao.selectProductDescription(productId));
		comment.setComments(getCommentList(productId));
		comment.setAverageScore((comment.getComments().size() != 0) ? getCommentAverage(productId) : 0);
		return comment;
	}

	private boolean isValidProductId(int productId) {
		return (productId > 0);
	}

}