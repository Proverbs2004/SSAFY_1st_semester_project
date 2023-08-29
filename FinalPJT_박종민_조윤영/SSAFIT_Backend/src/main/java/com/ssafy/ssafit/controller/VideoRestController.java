 package com.ssafy.ssafit.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import org.springframework.core.io.Resource;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-video")
@Api(tags = "비디오 컨트롤러")
@CrossOrigin("*")
public class VideoRestController {

	@Autowired
    private VideoService videoService;
    
    // 비디오 등록
    @PostMapping("/upload")
    public ResponseEntity<?> insertVideo(@RequestBody Video video) {
        int result = videoService.insertVideo(video);
        
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/{videoTitle}")
    public ResponseEntity<?> selectVideoByTitle(@PathVariable String videoTitle){
        return new ResponseEntity<Video>(videoService.selectVideoByTitle(videoTitle), HttpStatus.OK);
    }
    
    @GetMapping("/recommand")
    public ResponseEntity<?> recommendByRandomAndViews() {
        return new ResponseEntity<List<Video>>(videoService.recommendByRandomAndViews(), HttpStatus.OK);
    }
    
    @PutMapping("/like/{loginUser}")
    public ResponseEntity<?> likeVideo(Object data){
    	
    	
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @GetMapping("/selectAll")
    public ResponseEntity<?> videoSelectAll() {
        return new ResponseEntity<List<Video>>(videoService.videoSelectAll(), HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updatevideo(Video video) {
        videoService.updateVideo(video);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{videoTitle}")
    public ResponseEntity<?> deleteVideo(@PathVariable String videoTitle) {
        videoService.deleteVideo(videoTitle);
        System.out.println(videoTitle);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @PutMapping("/viewCnt")
    public ResponseEntity<?> upViewCnt(@RequestBody Video video) {
        videoService.upViewCnt(video);
        System.out.println("조회수 전달완료");
        System.out.println(video.getVideoViewcnt());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    
    
}