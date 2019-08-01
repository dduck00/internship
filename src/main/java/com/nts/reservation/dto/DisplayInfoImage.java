package com.nts.reservation.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("DisplayInfoImage")
public class DisplayInfoImage {
	private String contentType;
	private LocalDateTime createDate;
	private boolean deleteFlag;
	private int fileId;
	private String fileName;
	private LocalDateTime modifyDate;
	private int DisplayInfoId;
	private int DisplayInfoImageId;
	private String saveFileName;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
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

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
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
