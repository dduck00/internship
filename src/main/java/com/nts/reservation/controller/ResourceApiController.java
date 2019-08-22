package com.nts.reservation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.reservation.service.ResourceService;

@RestController
@RequestMapping("/resources/img")
public class ResourceApiController {
	private static final String PATH = "D:/resources/img/";

	private final ResourceService resourceService;

	@Autowired
	public ResourceApiController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@GetMapping("/{imageName:.+}")
	public void fileLoadFromLocal(HttpServletResponse response,
		@PathVariable String imageName) throws FileNotFoundException, IOException {

		String saveFileName = PATH + imageName;

		if (StringUtils.endsWithAny(StringUtils.lowerCase(imageName),
			new String[] {"png", "jpg", "jpeg", "gif"}) == false) {
			throw new FileNotFoundException("File Extension is wrong : " + imageName);
		}

		File file = new File(saveFileName);

		response.setHeader("Content-Disposition", "attachment; filename=\"" + imageName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", Files.probeContentType(Paths.get(saveFileName)));
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		resourceService.getFileData(saveFileName, response.getOutputStream());
	}

}
