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
import com.nts.reservation.service.ResourceService;

@Service
public class CommentServiceImpl implements CommentService {
	private static final Pattern EMAIL_PATTERN = Pattern.compile(
		"/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/");

	private final CommentDao commentDao;
	private final ResourceService resourceService;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao, ResourceService resourceService) {
		this.commentDao = commentDao;
		this.resourceService = resourceService;
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
	public void addComment(FileInfo fileInfo, CommentInfo commentInfo) {
		String comment = commentInfo.getComment();

		commentInfo.setComment(comment.length() > 400 ? comment.substring(0, 400) : comment);

		if (isValidEmail(commentInfo.getReservationEmail()) == false) {
			throw new IllegalArgumentException("Wrong Email");
		}

		if (isValidReservationInfoId(commentInfo.getReservationInfoId()) == false) {
			throw new IllegalArgumentException("Wrong displayInfo Id");
		}

	}

	@Override
	@Transactional
	public void addCommentDB(FileInfo fileInfo, CommentInfo commentInfo) {
		commentDao.insertComment(commentInfo);

		if (fileInfo != null) {
			commentDao.insertFile(fileInfo);
			commentDao.insertCommentImage(commentInfo.getReservationInfoId(), commentInfo.getCommentId(),
				fileInfo.getId());
		}
	}

	private boolean isValidProductId(int productId) {
		return productId > 0;
	}

	private boolean isValidReservationInfoId(int reservationInfoId) {
		return reservationInfoId > 0;
	}

	private boolean isValidEmail(String email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}
}