package com.nts.reservation.service;

import java.util.List;

import org.apache.commons.fileupload.FileUploadException;

import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.CommentList;
import com.nts.reservation.dto.FileInfo;

public interface CommentService {

	CommentList getCommentList(int productId);

	List<CommentInfo> getCommentInfoList(int productId, boolean isDetailPage);

	double getCommentAverage(List<CommentInfo> commentList);

	void addComment(FileInfo fileInfo, CommentInfo commentInfo) throws FileUploadException;

	void addCommentDB(FileInfo fileInfo, CommentInfo commentInfo);
}
