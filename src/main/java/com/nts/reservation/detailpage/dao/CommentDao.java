package com.nts.reservation.detailpage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nts.reservation.detailpage.dto.Comment;
import com.nts.reservation.detailpage.dto.CommentImage;

public interface CommentDao {
	List<Comment> selectCommentList(@Param("id") int productId);

	List<CommentImage> selectCommentImage(@Param("id") int commentId);
}
