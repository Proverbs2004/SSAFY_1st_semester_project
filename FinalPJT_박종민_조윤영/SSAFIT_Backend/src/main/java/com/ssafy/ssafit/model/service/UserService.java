package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	
	// 기능을 실제로 구현 함
	// 회원가입을 위해 Dao의 insertUser를 가져올 예정
	public int signup(User user);
	
	// 로그인
	public User login(String userId, String userPwd);
	
	// 로그아웃은 controller에서 작업할 예정
	
	// 유저의 글을 읽어올 예정, Dao의 3가지 기능을 구현할 예정
	// 아이디 별로 가져올 기능
	public User searchUserById (String userId);
	
	// 매너 포인트, 매너 포인트가 높은 순으로 추출
	public List<User> searchByMnpointDesc(); 
	
	// 전체 리스트 불러오기
	public List<User> getList();
	
	
	// 유저 업데이트
	public void modifyUser(User user);
	
	
	// 유저 삭제
	public void removeUser(String userId);
	
	
	
}
