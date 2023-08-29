package com.ssafy.ssafit.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Article {
	
	private int articleSeq; // 기본키 
	private String articleWriter;
	private String articleBoardType; // 게시판 종류
	private String articleTitle;
	private String articleContent;
	private LocalDateTime articleRegDate;

	public Article() {}

	public Article(int articleSeq, String articleWriter, String articleBoardType, String articleTitle, String articleContent,
			LocalDateTime articleRegDate) {
		super();
		this.articleSeq = articleSeq; 
		this.articleWriter = articleWriter;
		this.articleBoardType = articleBoardType;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleRegDate = articleRegDate;
	}

	public int getArticleSeq() {
		return articleSeq;
	}

	public void setArticleSeq(int articleSeq) {
		this.articleSeq = articleSeq;
	}

	public String getArticleWriter() {
		return articleWriter;
	}

	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public LocalDateTime getArticleRegDate() {
		return articleRegDate;
	}

	public void setArticleRegDate(LocalDateTime articleRegDate) {
		this.articleRegDate = articleRegDate;
	}

	public String getArticleBoardType() {
		return articleBoardType;
	}

	public void setArticleBoardType(String articleBoardType) {
		this.articleBoardType = articleBoardType;
	}

	@Override
	public String toString() {
		return "Article [articleSeq=" + articleSeq + ", articleWriter=" + articleWriter + ", articleBoardType=" + articleBoardType
				+ ", articleTitle=" + articleTitle + ", articleContent=" + articleContent + ", articleRegDate="
				+ articleRegDate + "]";
	}
	
	
}
