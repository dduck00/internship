package com.nts.reservation.detailpage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.nts.reservation.detailpage.dto.Comment;
import com.nts.reservation.detailpage.dto.CommentImage;

@Repository
public interface CommentDao {
	List<Comment> selectCommentList(@Param("id") int productId);

	List<CommentImage> selectCommentImageList(@Param("id") int commentId);
}
