package com.nts.reservation.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.nts.reservation.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	private static final String FILE_SAVE_LOCATION = "img/";

	@Override
	public void getFileData(String saveFileName, OutputStream outputStream) throws FileNotFoundException {
		try (FileInputStream fileInputStream = new FileInputStream(saveFileName);) {
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
	public String getSaveFileLocation(String fileName) {
		return FILE_SAVE_LOCATION + fileName;
	}

}
