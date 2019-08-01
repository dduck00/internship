package com.nts.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CommentDao;
import com.nts.reservation.dto.Comment;
import com.nts.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getCommentList(int productId) {
		return commentDao.selectCommentList(productId);
	}

	@Override
	public double getCommentAverage(int productId) {
		return commentDao.selectCommentAverage(productId);
	}

}
