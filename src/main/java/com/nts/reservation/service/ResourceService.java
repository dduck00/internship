package com.nts.reservation.service;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import com.nts.reservation.dto.FileInfo;

public interface ResourceService {
	void getFileData(HttpServletResponse response, String imageID) throws FileNotFoundException;

	void addCommentImage(FileInfo fileInfo) throws FileUploadException;

	String getSaveFileLocation(String fileName);
}
