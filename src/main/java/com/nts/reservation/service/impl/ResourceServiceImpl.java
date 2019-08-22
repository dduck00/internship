package com.nts.reservation.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.nts.reservation.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	private static final String FILE_SAVE_LOCATION = "img/";

	@Override
	public void getFileData(String saveFileName, OutputStream outputStream) throws FileNotFoundException {
		try {
			FileCopyUtils.copy(FileUtils.openInputStream(new File(saveFileName)), outputStream);
		} catch (IOException e) {
			throw new FileNotFoundException("No File : " + saveFileName);
		}
	}

	@Override
	public String getSaveFileLocation(String fileName) {
		return FILE_SAVE_LOCATION + fileName;
	}

}
