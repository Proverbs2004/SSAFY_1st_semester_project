package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.CommentDao;
import com.ssafy.ssafit.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
	// 의존성 주입
	@Autowired
	private CommentDao commentDao;

	@Override
	public int registComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Override
	public List<Comment> selectAllComment(int commentArticleSeq) {
		return commentDao.selectAll(commentArticleSeq);
	}

	@Override
	public int modifyComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

	@Override
	public int removeComment(int commentSeq) {
		return commentDao.deleteComment(commentSeq);
	}
	
}
