 package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

    // dao 주입 먼저 받기
    private VideoDao videoDao;

    @Autowired
    public void setVideoDao(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    // 비디오 삽입
    @Override
    public int insertVideo(Video video) {
        System.out.println("비디오 입력들어옴");
        // 먼저 전체 리스트를 가져오고
        List<Video> result = videoSelectAll();
        
        // 비디오가 있는지 확인후
        for(Video getVideo : result) {
            if (getVideo.getVideoSeq() == video.getVideoSeq()) {
                
                System.out.println("동일한 비디오가 있습니다");
                
                return 0 ;
            }
        }
        
        // 있으면 반환
        return videoDao.insertVideo(video);
    }

    @Override
    public Video selectVideoByTitle(String videoTitle) {
        List<Video> result = videoSelectAll();
        
        if(result == null) {
            System.out.println("비디오가 없습니다.");
            return null;
        }
        
        return videoDao.selectVideoByTitle(videoTitle);
    }

    @Override
    public List<Video> recommendByRandomAndViews() {
        
        List<Video> result = videoSelectAll();
        if(result == null) {
            System.out.println("비디오가 없습니다.");
            return null;
        }
        
        
        return videoDao.recommendByRandomAndViews();
    }

    @Override
    public List<Video> likeVideo(User user) {
        List<Video> result = videoSelectAll();
        if(result == null) {
            System.out.println("비디오가 없습니다.");
            return null;
        }
        
        return videoDao.likeVideo(user);
    }

    @Override
    public List<Video> videoSelectAll() {
        
        List<Video> result = videoDao.videoSelectAll();
        
        if(result == null) {
            System.out.println("등록된 비디오가 없습니다.");
            return null;
        }else {
        	return result;        	
        }
        
    }

    @Override
    public void updateVideo(Video video) {
        
        videoDao.updateVideo(video);

    }

    @Override
    public void deleteVideo(String videoTitle) {
        
        videoDao.deleteVideo(videoTitle);

    }

	@Override
	public void upViewCnt(Video video) {
		
//		Video result =  videoDao.upViewCnt(video);
		

	}

//	@Override
//	public Video getThumbnail(String videoThumbnailName) {
//		return videoDao.downloadThumbnail(videoThumbnailName);
//	}
//
//	@Override
//	public Video getVod(String videoVodName) {
//		
//		return videoDao.downloadVideo(videoVodName);
//	}

}