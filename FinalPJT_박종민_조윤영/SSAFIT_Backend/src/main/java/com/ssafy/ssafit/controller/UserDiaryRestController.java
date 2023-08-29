 package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.UserDiary;
import com.ssafy.ssafit.model.service.UserDiaryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/userDiary")
@Api(tags = "유저다이어리 컨트롤러")
@CrossOrigin("*")
public class UserDiaryRestController {
    
    @Autowired
    private UserDiaryService userDiaryService;
    
    @PostMapping("/write")
    public ResponseEntity<?> insertUserDiary(UserDiary userDiary){
        int result = userDiaryService.insertUserDiary(userDiary);
        
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("/id")
    public ResponseEntity<?> selectUserDiary (String userDiaryTitle){
        return new ResponseEntity<UserDiary>(userDiaryService.selectUserDiary(userDiaryTitle), HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> userDiarySelectAll(){
        return new ResponseEntity<List<UserDiary>>(userDiaryService.userDiarySelectAll(), HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> updateUserDiary(UserDiary userDiary){
        userDiaryService.updateUserDiary(userDiary);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserDiary(int diarySeq) {
        userDiaryService.deleteUserDiary(diarySeq);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}