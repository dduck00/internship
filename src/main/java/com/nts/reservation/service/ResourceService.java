package com.nts.reservation.service;

import java.io.FileNotFoundException;
import java.io.OutputStream;

public interface ResourceService {
	void getFileData(String imageID, OutputStream outputStream) throws FileNotFoundException;

	String getSaveFileLocation(String fileName);
}
