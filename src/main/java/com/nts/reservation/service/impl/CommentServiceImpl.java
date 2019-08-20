package com.nts.reservation.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.CommentDao;
import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.CommentList;
import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	private static final Pattern EMAIL_PATTERN = Pattern.compile(
		"/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/");

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

	@Override
	public void addComment(FileInfo fileInfo, String email, int productId, String comment) {

		comment = comment.length() > 400 ? comment.substring(0, 400) : comment;

		if (isValidEmail(email) == false) {
			throw new IllegalArgumentException("Wrong Email");
		}

		if (isValidProductId(productId) == false) {
			throw new IllegalArgumentException("Wrong prodcut Id");
		}

		addCommentDB(fileInfo, email, productId, comment);

	}

	@Transactional
	private void addCommentDB(FileInfo fileInfo, String email, int productId, String comment) {

	}

	private boolean isValidProductId(int productId) {
		return (productId > 0);
	}

	private boolean isValidEmail(String email) {
		if (email == null || EMAIL_PATTERN.matcher(email).matches()) {
			return false;
		}
		return true;
	}
}