package com.ssafy.ssafit.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	// 유저를 위한 CRUD
	// Create, 유저 생성
	public int insertUser(User user);
	
	
	// Read, db에 있는 자료들 가져오기 위함
	// 나중에 운영자가 회원 정보를 가져와야 함 
	public User selectByUserId(String userId);
	
	// 이것은 운영자가 매너포인트에 따른 
	public List<User> selectByUserMnpoint();
	
	// 전체 리스트 불러오기
	public List<User> userSelectAll();
	
	
	// update
	// 유저에 대한 정보를 다 받고 그 중 바꾸어야 하므로 User 객체를 다 받아준다
	public void updateUser(User user);
	
	
	// delete
	// 삭제할 때는 아이디사용 하고 service에서 비밀번호까지 확인
	public void deleteUser(String userId);
	
	

	
}
