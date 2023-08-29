 package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.UserDiary;

public interface UserDiaryDao {

    public int insertUserDiary(UserDiary userDiary);
    
    public UserDiary selectUserDiary(String userId);
    
    public List<UserDiary> userDiarySelectAll();
    
    public void updateUserDiary(UserDiary userDiary);
    
    public void deleteUserDiary(int diarySeq);
    
}