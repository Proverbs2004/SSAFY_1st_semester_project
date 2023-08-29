package com.ssafy.ssafit.model.dto;

public class VideoType {
	
	private int videoTypeSeq;
	private String videoType;
	
	public VideoType() { }

	public VideoType(int videoTypeSeq, String videoType) {
		super();
		this.videoTypeSeq = videoTypeSeq;
		this.videoType = videoType;
	}

	public int getVideoTypeSeq() {
		return videoTypeSeq;
	}

	public void setVideoTypeSeq(int videoTypeSeq) {
		this.videoTypeSeq = videoTypeSeq;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	
}
