package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.CommentImage;
import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.FileInfo;

@Repository
public interface CommentDao {

	List<CommentInfo> selectCommentInfoList(@Param("id") int productId, @Param("isDetailPage") boolean isDetailPage);

	List<CommentImage> selectCommentImageList(@Param("id") int commentId);

	String selectProductDescription(@Param("id") int productId);

	void insertFile(FileInfo fileInfo);

	void insertComment(CommentInfo commentInfo);

	void insertCommentImage(int reservationInfoId, int resrationUserCommentId, int fileId);
}
