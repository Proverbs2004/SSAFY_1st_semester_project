 package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDiaryDao;
import com.ssafy.ssafit.model.dto.UserDiary;

@Service
public class UserDiaryServiceImpl implements UserDiaryService {

    private UserDiaryDao userDiaryDao;
    
    @Autowired
    public void setUserDiaryService (UserDiaryDao userDiaryDao) {
        this.userDiaryDao = userDiaryDao;
    }
    
    @Override
    public int insertUserDiary(UserDiary userDiary) {
        userDiaryDao.insertUserDiary(userDiary);
        
        return userDiaryDao.insertUserDiary(userDiary);
    }

    @Override
    public UserDiary selectUserDiary(String userDiaryTitle) {
        
        UserDiary getUserDiary = userDiaryDao.selectUserDiary(userDiaryTitle);
        
        if(getUserDiary == null) {
            return null;
        }
        
        return getUserDiary;
    }

    @Override
    public List<UserDiary> userDiarySelectAll() {
        
        List<UserDiary> resultList = userDiaryDao.userDiarySelectAll() ;
        
        // 중복 확인 하기
                if (resultList == null ) {
                    System.out.println("작성한 일지가 없습니다");
                    return null;
                } else { // 만약 리스트가 있으면 리스트 반환
                    return resultList;
                }
    }

    @Override
    public void updateUserDiary(UserDiary userDiary) {
        userDiaryDao.updateUserDiary(userDiary);
    }

    @Override
    public void deleteUserDiary(int diarySeq) {
        userDiaryDao.deleteUserDiary(diarySeq);
    }

}