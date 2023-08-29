package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Article;

public interface ArticleDao {
	
	// CRUD(게시글)
	
	// CREATE
	int insertArticle(Article article);
	
	// READ
	List<Article> selectAll(); // 전체 게시글 읽기
	List<Article> selectByType(String type); // 주제별 게시글 읽기
	List<Article> selectByTitle(String title); // 타이틀에 특정 단어가 포함된 게시글들 읽기
	List<Article> selectByWriter(String userId); // 작성자로 게시글 읽기
	Article selectBySeq(int articleSeq); // 기본키로 게시글 1개 읽기
	
	// UPDATE
	// 다 int형으로 반환시켜서 몇개의 행이 동작했는지 확인하기 위함
	int updateArticle(Article article);
	
	// DELETE
	int deleteArticle(int articleSeq);
	
	
}
