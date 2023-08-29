 package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {

    public int insertVideo(Video video);
    
//    public Video getThumbnail (String videoThumbnailName);
//    
//    public Video getVod (String videoVodName);
    
    public Video selectVideoByTitle(String videoTitle);
    
    public List<Video> recommendByRandomAndViews();
    
    public List<Video> likeVideo(User user);
    
    public List<Video> videoSelectAll();
    
    public void updateVideo(Video video);
    
    public void deleteVideo(String videoTitle);
    
    public void upViewCnt(Video video);
    
}