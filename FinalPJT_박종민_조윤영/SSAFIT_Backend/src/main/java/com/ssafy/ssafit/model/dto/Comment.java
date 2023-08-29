package com.ssafy.ssafit.model.dto;

//import java.time.LocalDateTime;

public class Comment {

    private int commentSeq;
    private String commentWriter;
    private String commentContent;
    private int commentArticleSeq; 
//    private LocalDateTime commentRegDate;
    
    public Comment() {  }

	public Comment(int commentSeq, String commentWriter, String commentContent, int commentArticleSeq) {
		super();
		this.commentSeq = commentSeq;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.commentArticleSeq = commentArticleSeq;
	}
    
//	public Comment(int commentSeq, String commentWriter, String commentContent, LocalDateTime commentRegDate,
//			int articleSeq) {
//		super();
//		this.commentSeq = commentSeq;
//		this.commentWriter = commentWriter;
//		this.commentContent = commentContent;
//		this.commentRegDate = commentRegDate;
//		this.articleSeq = articleSeq;
//	}


	public int getCommentSeq() {
        return commentSeq;
    }

    public int getCommentArticleSeq() {
		return commentArticleSeq;
	}

	public void setCommentArticleSeq(int commentArticleSeq) {
		this.commentArticleSeq = commentArticleSeq;
	}

	public void setCommentSeq(int commentSeq) {
        this.commentSeq = commentSeq;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

	@Override
	public String toString() {
		return "Comment [commentSeq=" + commentSeq + ", commentWriter=" + commentWriter + ", commentContent="
				+ commentContent + ", commentArticleSeq=" + commentArticleSeq + "]";
	}

//	public LocalDateTime getCommentRegDate() {
//		return commentRegDate;
//	}
//
//	public void setCommentRegDate(LocalDateTime commentRegDate) {
//		this.commentRegDate = commentRegDate;
//	}
    
    

}