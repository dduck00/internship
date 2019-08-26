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

import com.nts.reservation.dao.DisplayDao;

@RestController
@RequestMapping("/get-img/")
public class ResourceApiController {
	private static final String PATH = "D:/resources/";
	private static final String[] contentTypeFilterArray = new String[] {"png", "jpg", "jpeg", "gif"};

	private final DisplayDao displayDao;

	@Autowired
	public ResourceApiController(DisplayDao displayDao) {
		this.displayDao = displayDao;
	}

	@GetMapping("/product/{productId}")
	public void loadProductImage(HttpServletResponse response,
		@PathVariable int productId) throws FileNotFoundException, IOException {

		String imageName = displayDao.selectProductImageList(productId).get(0).getSaveFileName();

		String saveFileName = PATH + imageName;

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

	@GetMapping("/map/{displayId}")
	public void loadMapImage(HttpServletResponse response,
		@PathVariable int displayId) throws FileNotFoundException, IOException {

		String imageName = displayDao.selectDisplayInfoImage(displayId).getSaveFileName();

		String saveFileName = PATH + imageName;

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

	@GetMapping("/comment/{imageName:.+}")
	public void fileLoadFromLocal(HttpServletResponse response,
		@PathVariable String imageName) throws FileNotFoundException, IOException {

		String saveFileName = PATH + imageName;

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
