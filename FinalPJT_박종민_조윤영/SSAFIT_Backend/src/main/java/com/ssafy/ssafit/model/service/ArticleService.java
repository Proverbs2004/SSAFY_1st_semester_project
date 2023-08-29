package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Article;

public interface ArticleService {
	
	int registArticle(Article article);
	
	List<Article> selectAllArticle();
	List<Article> selectArticleByType(String type);
	List<Article> selectArticleByTitle(String title);
	List<Article> selectArticleByWriter(String userId);
	Article selectArticleBySeq(int articleSeq);
	
	int modifyArticle(Article article);
	
	int removeArticle(int articleSeq);
	
}
