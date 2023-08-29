package com.ssafy.ssafit.model.dto;

public class WishList {

	private int wishSeq;
	private String userId;
	private String videoSeq;
	
	public WishList() {
		// TODO Auto-generated constructor stub
	}

	public WishList(int wishSeq, String userId, String videoSeq) {
		super();
		this.wishSeq = wishSeq;
		this.userId = userId;
		this.videoSeq = videoSeq;
	}

	public int getWishSeq() {
		return wishSeq;
	}

	public void setWishSeq(int wishSeq) {
		this.wishSeq = wishSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVideoSeq() {
		return videoSeq;
	}

	public void setVideoSeq(String videoSeq) {
		this.videoSeq = videoSeq;
	}
	
	
}