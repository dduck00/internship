package com.nts.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CommentDao;
import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.CommentList;
import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<CommentInfo> getCommentInfoList(int productId, boolean isDetailPage) {
		return commentDao.selectCommentInfoList(productId, isDetailPage);
	}

	@Override
	public double getCommentAverage(List<CommentInfo> commentInfoList) {
		return commentInfoList.stream()
			.mapToInt(CommentInfo::getScore)
			.average()
			.orElse(0);
	}

	@Override
	public CommentList getCommentList(int productId) {

		if (isValidProductId(productId) == false) {
			throw new IllegalArgumentException("productId가 음수입니다.");
		}

		CommentList commentList = new CommentList();

		commentList.setProductDescription(commentDao.selectProductDescription(productId));
		commentList.setComments(getCommentInfoList(productId, false));
		commentList.setAverageScore(getCommentAverage(commentList.getComments()));

		return commentList;
	}

	private boolean isValidProductId(int productId) {
		return (productId > 0);
	}

	@Override
	public void addComment(FileInfo fileInfo, String email, int productId, String comment) {
		System.out.println(email);
		System.out.println(productId);
	}

}