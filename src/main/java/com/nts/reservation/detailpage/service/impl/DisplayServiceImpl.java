package com.nts.reservation.detailpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.detailpage.dao.CommentDao;
import com.nts.reservation.detailpage.dao.DisplayDao;
import com.nts.reservation.detailpage.dto.Comment;
import com.nts.reservation.detailpage.dto.DisplayDetail;
import com.nts.reservation.detailpage.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {

	private DisplayDao displayDao;
	private CommentDao commentDao;

	@Autowired
	public DisplayServiceImpl(DisplayDao displayDao, CommentDao commentDao) {
		this.displayDao = displayDao;
		this.commentDao = commentDao;
	}

	@Override
	public DisplayDetail getDisplayDetail(int displayId) {
		DisplayDetail displayDetail = new DisplayDetail();

		displayDetail.setDisplayInfo(displayDao.selectDisplayInfo(displayId));
		displayDetail.setDisplayInfoImage(displayDao.selectDisplayInfoImage(displayId));

		int productId = displayDetail.getDisplayInfo().getProductId();

		displayDetail.setProductImages(displayDao.selectProductImageList(productId));
		displayDetail.setProductPrices(displayDao.selectProductPriceList(productId));
		displayDetail.setAverageScore(displayDao.selectProductAverage(productId));

		displayDetail.setComments(commentDao.selectCommentList(productId));

		for (Comment comment : displayDetail.getComments()) {
			comment.setCommentImages(commentDao.selectCommentImageList(comment.getCommentId()));
		}

		return displayDetail;
	}

}
