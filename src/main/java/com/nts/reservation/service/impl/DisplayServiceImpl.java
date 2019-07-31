package com.nts.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.reservation.dao.CommentDao;
import com.nts.reservation.dao.DisplayDao;
import com.nts.reservation.dto.Comment;
import com.nts.reservation.dto.Display;
import com.nts.reservation.service.DisplayService;

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
	public Display getDisplay(int displayId) {
		Display display = new Display();

		display.setDisplayInfo(displayDao.selectDisplayInfo(displayId));
		display.setDisplayInfoImage(displayDao.selectDisplayInfoImage(displayId));

		int productId = display.getDisplayInfo().getProductId();

		display.setProductImages(displayDao.selectProductImageList(productId));
		display.setProductPrices(displayDao.selectProductPriceList(productId));

		display.setComments(commentDao.selectCommentList(productId));

		display.setAverageScore((display.getComments().size() != 0) ? displayDao.selectProductAverage(productId) : 0);

		for (Comment comment : display.getComments()) {
			comment.setCommentImages(commentDao.selectCommentImageList(comment.getCommentId()));
		}

		return display;
	}

}
