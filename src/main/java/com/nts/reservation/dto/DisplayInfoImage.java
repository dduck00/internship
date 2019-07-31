package com.nts.reservation.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("DisplayInfoImage")
public class DisplayInfoImage {
	private String contentType;
	private Timestamp createDate;
	private boolean deleteFlag;
	private int fileId;
	private String fileName;
	private Timestamp modifyDate;
	private int DisplayInfoId;
	private int DisplayInfoImageId;
	private String saveFileName;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getDisplayInfoId() {
		return DisplayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		DisplayInfoId = displayInfoId;
	}

	public int getDisplayInfoImageId() {
		return DisplayInfoImageId;
	}

	public void setDisplayInfoImageId(int displayInfoImageId) {
		DisplayInfoImageId = displayInfoImageId;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
}
