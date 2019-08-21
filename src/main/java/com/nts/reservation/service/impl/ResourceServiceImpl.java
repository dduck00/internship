package com.nts.reservation.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Service;

import com.nts.reservation.dto.FileInfo;
import com.nts.reservation.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	private static final String FILE_SAVE_LOCATION = "img/";

	@Override
	public void getFileData(HttpServletResponse response, String imageName) throws FileNotFoundException {

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

		try (FileInputStream fileInputStream = new FileInputStream(saveFileName);
			OutputStream outputStream = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];

			while ((readCount = fileInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, readCount);
			}
		} catch (IOException e) {
			throw new FileNotFoundException("No File : " + saveFileName);
		}
	}

	@Override
	public void addCommentImage(FileInfo fileInfo) throws FileUploadException {

		try (FileOutputStream fileOutputStream = new FileOutputStream("D:/resources/" + fileInfo.getSaveFileName());
			InputStream inputStream = fileInfo.getInputStream();) {

			int readCount = 0;
			byte[] buffer = new byte[1024];

			while ((readCount = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, readCount);
			}

		} catch (FileNotFoundException e) {
			throw new FileUploadException("File OutputStream get Fail");
		} catch (IOException e) {
			throw new FileUploadException("File InputStream get Fail");
		}

	}

	@Override
	public String getSaveFileLocation(String fileName) {
		return FILE_SAVE_LOCATION + System.currentTimeMillis() + fileName;
	}

}
