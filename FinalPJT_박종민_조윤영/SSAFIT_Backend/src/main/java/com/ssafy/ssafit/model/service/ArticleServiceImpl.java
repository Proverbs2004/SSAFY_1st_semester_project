package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ArticleDao;
import com.ssafy.ssafit.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;

	@Override
	public int registArticle(Article article) {
		return articleDao.insertArticle(article);
	}

	@Override
	public List<Article> selectAllArticle() {
		return articleDao.selectAll();
	}

	@Override
	public List<Article> selectArticleByType(String type) {
		return articleDao.selectByType(type);
	}

	@Override
	public List<Article> selectArticleByTitle(String title) {
		return articleDao.selectByTitle(title);
	}

	@Override
	public List<Article> selectArticleByWriter(String userId) {
		return articleDao.selectByWriter(userId);
	}

	@Override
	public Article selectArticleBySeq(int articleSeq) {
		return articleDao.selectBySeq(articleSeq);
	}

	@Override
	public int modifyArticle(Article article) {
		return articleDao.updateArticle(article);
	}

	@Override
	public int removeArticle(int articleSeq) {
		return articleDao.deleteArticle(articleSeq);
	}
	
}
