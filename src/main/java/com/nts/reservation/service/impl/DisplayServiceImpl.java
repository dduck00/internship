package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.DisplayDao;
import com.nts.reservation.dto.Display;
import com.nts.reservation.service.CommentService;
import com.nts.reservation.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {

	private final DisplayDao displayDao;
	private final CommentService commentService;

	@Autowired
	public DisplayServiceImpl(DisplayDao displayDao, CommentService commentService) {
		this.displayDao = displayDao;
		this.commentService = commentService;
	}

	@Override
	public Display getDisplay(int displayId) {

		if (isValidDisplayId(displayId) == false) {
			throw new IllegalArgumentException("displayId is a negative quantity");
		}

		Display display = new Display();

		display.setDisplayInfo(displayDao.selectDisplayInfo(displayId));
		display.setDisplayInfoImage(displayDao.selectDisplayInfoImage(displayId));

		if (display.getDisplayInfo() == null) {
			throw new DataRetrievalFailureException("there is no display ** " + displayId);
		}

		int productId = display.getDisplayInfo().getProductId();

		display.setProductImages(displayDao.selectProductImageList(productId));
		display.setProductPrices(displayDao.selectProductPriceList(productId));

		display.setComments(commentService.getCommentInfoList(productId, true));
		display.setAverageScore(
			(display.getComments().size() != 0) ? displayDao.selectDisplayCommentAverage(productId) : 0);

		return display;
	}

	private boolean isValidDisplayId(int displayId) {
		return (displayId > 0);
	}

}