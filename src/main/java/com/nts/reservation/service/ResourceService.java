package com.nts.reservation.service;

import java.io.IOException;
import java.io.OutputStream;

public interface ResourceService {
	void getFileData(String imageID, OutputStream outputStream) throws IOException;

	String getSaveFileLocation(String fileName);
}
