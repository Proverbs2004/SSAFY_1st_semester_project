package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Comment;

public interface CommentService {
	
	int registComment(Comment comment);
	
	// 댓글은 하나씩 불러오기 없이 전체 댓글만 반환할 예정
	List<Comment> selectAllComment(int articleSeq);
	
	int modifyComment(Comment comment);
	
	int removeComment(int commentSeq);
	
}
