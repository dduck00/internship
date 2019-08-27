package com.nts.reservation.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

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

@RestController
@RequestMapping(path = "/api")
public class CommentApiController {
	private static final String[] contentTypeFilterArray = new String[] {"png", "jpg", "jpeg"};
	private static final String FILE_SAVE_LOCATION = "D:/resources/comment/";

	private final CommentService commentService;

	@Autowired
	public CommentApiController(CommentService commentService) {
		this.commentService = commentService;
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

		try {

			if (StringUtils.isNotBlank(fileInfo.getFileName())) {
				fileInfo.setSaveFileName(getSaveFileLocation(fileInfo.getFileName()));
				newFile = new File(FILE_SAVE_LOCATION + fileInfo.getSaveFileName());
				newFile.getParentFile().mkdirs();
				file.transferTo(newFile);
			}

		} catch (IllegalStateException | IOException e) {
			throw new FileUploadException("File Upload Fail", e);
		}

		try {
			commentService.addComment(fileInfo, commentInfo);
		} catch (RuntimeException e) {

			if (newFile != null) {
				newFile.delete();
			}
			throw e;
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/myreservation?resrv_email=" + cookieEmail);
		return modelAndView;
	}

	private FileInfo buildFileInfo(MultipartFile file) throws FileUploadException {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(StringUtils.lowerCase(file.getOriginalFilename()));
		fileInfo.setContentType(StringUtils.lowerCase(file.getContentType()));

		if (StringUtils.endsWithAny(file.getContentType(), contentTypeFilterArray) == false) {
			throw new FileUploadException("File contentType wrong : " + file.getContentType());
		}

		LocalDate nowTime = LocalDate.now();

		fileInfo.setCreateDate(nowTime);
		fileInfo.setModifyDate(nowTime);

		return fileInfo;
	}

	private String getSaveFileLocation(String fileName) {
		return UUID.randomUUID() + "/" + UUID.randomUUID() + "/" + fileName;
	}

}