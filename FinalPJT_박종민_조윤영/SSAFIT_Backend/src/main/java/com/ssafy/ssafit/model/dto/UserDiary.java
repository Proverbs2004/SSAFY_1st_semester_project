package com.ssafy.ssafit.model.dto;

import java.util.Date;

public class UserDiary {
	
	private int diarySeq;
	private String userId;
	private Date diaryDate;
	private String diaryContent;
	
	public UserDiary() {
		// TODO Auto-generated constructor stub
	}

	public UserDiary(int diarySeq, String userId, Date diaryDate, String diaryContent) {
		super();
		this.diarySeq = diarySeq;
		this.userId = userId;
		this.diaryDate = diaryDate;
		this.diaryContent = diaryContent;
	}

	public int getDiarySeq() {
		return diarySeq;
	}

	public void setDiarySeq(int diarySeq) {
		this.diarySeq = diarySeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}

	public String getDiaryContent() {
		return diaryContent;
	}

	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	
	
	
}
