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

	private final ResourceService resourceService;

	@Autowired
	public ResourceApiController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@GetMapping("/{imageName}")
	public void fileLoadFromLocal(HttpServletResponse response,
		@PathVariable String imageName) throws FileNotFoundException, IOException {

		String fileName = imageName + ".png";
		String saveFileName = "D:/resources/img/" + imageName + ".png";
		String contentType = "image/png";

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
