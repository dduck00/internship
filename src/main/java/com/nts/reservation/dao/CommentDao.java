package com.nts.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.CommentInfo;
import com.nts.reservation.dto.CommentImage;

@Repository
public interface CommentDao {
	List<CommentInfo> selectCommentList(@Param("id") int productId);

	List<CommentImage> selectCommentImageList(@Param("id") int commentId);

	double selectCommentAverage(@Param("id") int productId);
}
