package com.nts.reservation.controller;

import java.io.FileNotFoundException;

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

	@GetMapping("/{imageID}")
	public void fileLoadFromLocal(HttpServletResponse response,
		@PathVariable String imageID) throws FileNotFoundException {
		resourceService.getFileData(response, imageID);
	}

}
