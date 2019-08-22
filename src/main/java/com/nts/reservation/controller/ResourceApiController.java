package com.nts.reservation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.ResourceService;

@RestController
@RequestMapping("/resources/img")
public class ResourceApiController {
	private static final String PNG = ".png";
	private static final String JPG = ".jpg";
	private static final String GIF = ".gif";
	private static final String PATH = "D:/resources/img/";

	private final ResourceService resourceService;

	@Autowired
	public ResourceApiController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@GetMapping("/{imageName}")
	public void fileLoadFromLocal(HttpServletResponse response,
		@PathVariable String imageName) throws FileNotFoundException, IOException {

		File pngFile = new File(PATH + imageName + PNG);
		File jpgFile = new File(PATH + imageName + JPG);
		File gifFile = new File(PATH + imageName + GIF);

		String contentType;
		String fileName;

		if (pngFile.isFile()) {
			contentType = "image/png";
			fileName = imageName + PNG;
		} else if (jpgFile.isFile()) {
			contentType = "image/jpg";
			fileName = imageName + JPG;
		} else if (gifFile.isFile()) {
			contentType = "image/gif";
			fileName = imageName + GIF;
		} else {
			throw new FileNotFoundException("File not exist");
		}

		String saveFileName = PATH + fileName;

		File file = new File(saveFileName);

		response.setHeader("Content-Length", "" + file.length());

		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", contentType);
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		resourceService.getFileData(saveFileName, response.getOutputStream());
	}

}
