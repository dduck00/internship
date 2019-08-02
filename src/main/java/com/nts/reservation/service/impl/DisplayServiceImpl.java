package com.nts.reservation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.DisplayDao;
import com.nts.reservation.dto.Display;
import com.nts.reservation.service.CommentService;
import com.nts.reservation.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {

	private final DisplayDao displayDao;
	private final CommentService commentService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public DisplayServiceImpl(DisplayDao displayDao, CommentService commentService) {
		this.displayDao = displayDao;
		this.commentService = commentService;
	}

	@Override
	public Display getDisplay(int displayId) {
		Display display = new Display();

		if (isValidDisplayId(displayId) == false) {
			logger.error("displayId가 음수입니다.");
			return display;
		}

		display.setDisplayInfo(displayDao.selectDisplayInfo(displayId));
		display.setDisplayInfoImage(displayDao.selectDisplayInfoImage(displayId));

		if (display.getDisplayInfo() == null) {
			logger.error("displayId에 해당하는 전시정보가 없습니다. ** " + displayId);
			return display;
		}

		int productId = display.getDisplayInfo().getProductId();

		display.setProductImages(displayDao.selectProductImageList(productId));
		display.setProductPrices(displayDao.selectProductPriceList(productId));

		display.setComments(commentService.getCommentList(productId));

		display.setAverageScore((display.getComments().size() != 0) ? commentService.getCommentAverage(productId) : 0);

		return display;
	}

	private boolean isValidDisplayId(int displayId) {
		return (displayId > 0);
	}
}
