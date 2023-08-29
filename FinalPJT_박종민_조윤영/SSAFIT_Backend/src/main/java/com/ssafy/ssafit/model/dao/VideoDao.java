 package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {

    // Video CRUD 만들기
    // Create, 비디오 생성
    int insertVideo(Video video);

    // Read, db에 있는 자료들 가져오기 위함
    // 제목에 맞는 하나 가져오기
    Video selectVideoByTitle(String videoTitle);
    
    // 추천리스트, 조회수가 높은 것들 중에 랜덤으로 추천
    List<Video> recommendByRandomAndViews();

    // 찜리스트
    List<Video> likeVideo(User user);

    // 전체 리스트 불러오기
    List<Video> videoSelectAll();

    // update
    void updateVideo(Video video);
    
    // delete
    // title을 받아 삭제하기
    void deleteVideo(String videoTitle);
    
    void upViewCnt(Video video);
    
//	// 썸네일 업로드 
//    void uploadThumbnail(Video video);
//  	
	// 썸네일 다운로드
//    Video downloadThumbnail(String filename);
//    
//    // 비디오 업로드
//    void uploadVideo(Video video);
//    
    // 비디오 다운로드
//    Video downloadVideo(String videoVodName);
    
}