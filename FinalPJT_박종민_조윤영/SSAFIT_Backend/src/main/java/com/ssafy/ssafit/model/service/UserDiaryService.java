 package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserDiary;

public interface UserDiaryService {

    public int insertUserDiary(UserDiary userDiary);
    
    public UserDiary selectUserDiary(String userDiaryTitle);
    
    public List<UserDiary> userDiarySelectAll();
    
    public void updateUserDiary(UserDiary userDiary);
    
    public void deleteUserDiary(int diarySeq);
    
}