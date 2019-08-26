package com.nts.reservation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.dao.CommentDao;
import com.nts.reservation.dao.DisplayDao;

@RestController
@RequestMapping("/get-img/")
public class ResourceApiController {
	private static final String PATH = "D:/resources/";
	private static final String COMMENT_PATH = "D:/resources/comment/";
	private static final String[] contentTypeFilterArray = new String[] {"png", "jpg", "jpeg", "gif"};

	private final DisplayDao displayDao;
	private final CommentDao commentDao;

	@Autowired
	public ResourceApiController(DisplayDao displayDao, CommentDao commentDao) {
		this.displayDao = displayDao;
		this.commentDao = commentDao;
	}

	@GetMapping("/product/{productId}")
	public void loadProductImage(HttpServletResponse response,
		@PathVariable int productId) throws FileNotFoundException, IOException {

		String imageName = displayDao.selectProductImageList(productId).get(0).getSaveFileName();

		saveFile(response, imageName, PATH + imageName);
	}

	@GetMapping("/map/{displayId}")
	public void loadMapImage(HttpServletResponse response,
		@PathVariable int displayId) throws FileNotFoundException, IOException {

		String imageName = displayDao.selectDisplayInfoImage(displayId).getSaveFileName();

		saveFile(response, imageName, PATH + imageName);
	}

	@GetMapping("/comment/{commentId}")
	public void loadCommentImage(HttpServletResponse response,
		@PathVariable int commentId) throws FileNotFoundException, IOException {

		String imageName = commentDao.selectCommentImageList(commentId).get(0).getSaveFileName();

		saveFile(response, imageName, COMMENT_PATH + imageName);
	}

	private void saveFile(HttpServletResponse response, String imageName, String saveFileName)
		throws FileNotFoundException, IOException {

		if (StringUtils.endsWithAny(StringUtils.lowerCase(imageName), contentTypeFilterArray) == false) {
			throw new FileNotFoundException("File Extension is wrong : " + imageName);
		}

		File file = new File(saveFileName);

		response.setHeader("Content-Disposition", "attachment; filename=\"" + imageName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", Files.probeContentType(Paths.get(saveFileName)));
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		FileCopyUtils.copy(FileUtils.openInputStream(file), response.getOutputStream());
	}

}
