package com.nts.reservation.detailpage.service.impl;

import com.nts.reservation.detailpage.dao.DisplayDao;
import com.nts.reservation.detailpage.dto.Comment;
import com.nts.reservation.detailpage.dto.DisplayDetail;
import com.nts.reservation.detailpage.service.DisplayService;

public class DisplayServiceImpl implements DisplayService {

	DisplayDao displayDao;

	@Override
	public DisplayDetail getDisplayDetail(int displayId) {
		DisplayDetail displayDetail = displayDao.selectDisplayDetail(displayId);
		displayDetail.setDisplayInfo(displayDao.selectDisplayInfo(displayId));
		displayDetail.setProductImages(displayDao.selectProductImageList(displayId));
		displayDetail.setProductPrices(displayDao.selectProductPriceList(displayId));
		displayDetail.setDisplayInfoImage(displayDao.selectDisplayInfoImage(displayId));

		for (Comment comment : displayDetail.getComments()) {
			comment.setCommentImages(displayDao.selectCommentImage(comment.getCommentId()));
		}

		return displayDetail;
	}

}
