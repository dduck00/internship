package com.nts.reservation.service;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import org.apache.commons.fileupload.FileUploadException;

import com.nts.reservation.dto.FileInfo;

public interface ResourceService {
	void getFileData(String imageID, OutputStream outputStream) throws FileNotFoundException;

	void addCommentImage(FileInfo fileInfo) throws FileUploadException;

	String getSaveFileLocation(String fileName);
}
