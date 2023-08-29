package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Comment;

public interface CommentDao {
	
	// CRUD(댓글)
	
	// CREATE
	int insertComment(Comment comment);
	
	// READ
	// 해당 글에 대한 전체 댓글 가져오기
	List<Comment> selectAll(int articleSeq);
	
	// 댓글 하나 가져오는거 추가(Service에서 이용하려고)
	Comment selectBySeq(int commentSeq);
	
	// UPDATE
	// 댓글 수정
	int updateComment(Comment comment);
	
	// DELETE
	// 댓글 삭제
	int deleteComment(int commentSeq);
	
}
