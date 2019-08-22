package com.nts.reservation.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.CommentList;
import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.service.CommentService;
import com.nts.reservation.service.ResourceService;

@RestController
@RequestMapping(path = "/api")
public class CommentApiController {

	private final CommentService commentService;
	private final ResourceService resourceService;

	@Autowired
	public CommentApiController(CommentService commentService, ResourceService resourceService) {
		this.commentService = commentService;
		this.resourceService = resourceService;
	}

	@GetMapping("/comments/{productId}")
	public CommentList responseCommentList(@PathVariable int productId) {
		return commentService.getCommentList(productId);
	}

	@PostMapping("/add-comment/{reservationInfoId}")
	public ModelAndView addComment(@PathVariable int reservationInfoId,
		@CookieValue(value = "email") String cookieEmail,
		@RequestParam(value = "file", required = false) MultipartFile file,
		@RequestParam("comment") String comment,
		@RequestParam("score") int score) throws FileUploadException {

		CommentInfo commentInfo = new CommentInfo();
		commentInfo.setReservationEmail(cookieEmail);
		commentInfo.setComment(StringUtils.stripToEmpty(comment));
		commentInfo.setReservationInfoId(reservationInfoId);
		commentInfo.setScore(score);

		FileInfo fileInfo = buildFileInfo(file);
		File newFile = null;

		if (StringUtils.isBlank(fileInfo.getFileName()) == false) {

			try {

				fileInfo.setSaveFileName(resourceService.getSaveFileLocation(fileInfo.getFileName()));
				newFile = new File("D:/resources/" + fileInfo.getSaveFileName());
				file.transferTo(newFile);

			} catch (IllegalStateException | IOException e) {
				throw new FileUploadException("File Upload Fail");
			}
		}

		try {

			commentService.addComment(fileInfo, commentInfo);
			commentService.addCommentDB(fileInfo, commentInfo);

		} catch (RuntimeException e) {

			if (newFile != null) {
				newFile.delete();
			}
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/myreservation?resrv_email=" + cookieEmail);
		return modelAndView;
	}

	private FileInfo buildFileInfo(MultipartFile file) throws FileUploadException {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(file.getOriginalFilename());
		fileInfo.setContentType(file.getContentType());
		if (StringUtils.containsIgnoreCase(file.getContentType(), "png") == false
			&& StringUtils.containsIgnoreCase(file.getContentType(), "jpg") == false) {

			throw new FileUploadException("File contentType wrong");
		}

		LocalDate nowTime = LocalDate.now();

		fileInfo.setCreateDate(nowTime);
		fileInfo.setModifyDate(nowTime);

		return fileInfo;
	}

}