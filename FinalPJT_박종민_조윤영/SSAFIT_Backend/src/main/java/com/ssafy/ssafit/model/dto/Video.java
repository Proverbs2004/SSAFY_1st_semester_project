 package com.ssafy.ssafit.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class Video {
    private String videoSeq;
    private String videoTitle;
    private String videoUrl;
    
//    private String videoThumbnailName;
//    private String videoThumbnailType;
//    private byte[] videoThumbnailData;
//    private String videoVodName;
//    private MultipartFile videoVodData;
    private int videoViewcnt;
    private String videoPart;

    public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(String videoSeq, String videoTitle, String videoUrl, int videoViewcnt, String videoPart) {
		super();
		this.videoSeq = videoSeq;
		this.videoTitle = videoTitle;
		this.videoUrl = videoUrl;
		this.videoViewcnt = videoViewcnt;
		this.videoPart = videoPart;
	}

	public String getVideoSeq() {
		return videoSeq;
	}

	public void setVideoSeq(String videoSeq) {
		this.videoSeq = videoSeq;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getVideoViewcnt() {
		return videoViewcnt;
	}

	public void setVideoViewcnt(int videoViewcnt) {
		this.videoViewcnt = videoViewcnt;
	}

	public String getVideoPart() {
		return videoPart;
	}

	public void setVideoPart(String videoPart) {
		this.videoPart = videoPart;
	}
    
    
}