package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;


@Service
public class UserServiceImpl implements UserService {

	// 먼저 UserDao 주입
	@Autowired
	private UserDao userDao;
	
	
	@Override
	@Transactional
	public int signup(User user) {
		
		// 중복 확인 처리
		List<User> checkList = getList();
		
		for (User checkUser : checkList ) {
			if (user.getUserId().equals(checkUser.getUserId())) {
				System.out.println("중복된 아이디가 있습니다.");
				
				return 0;
				
				
			} 
		}
		
		// 만약 중복이 된 것이 없다면 유저등록 실행
		return userDao.insertUser(user);
	}

	@Override
	public User searchUserById(String userId) {
		
		// Dao를 통해 하나 가져오기
		User getUser = userDao.selectByUserId(userId);
		
		if (getUser == null) {
			System.out.println("해당 아이디를 가진 유저가 없습니다.");
			return null;
		} else {
			return getUser;
		}
		
	}

	@Override
	public List<User> searchByMnpointDesc() {
		
		// Dao의 메서드를 통해 매너포인트를 통한 정렬된 리스트를 가녀옴
		List<User> resultList = userDao.selectByUserMnpoint();
		
		// null 확인
		if(resultList == null) {
			System.out.println("유저가 없습니다.");
			return null;
		} else { // 1명이라도 있으면 내보냄
			return resultList;			
		}
		
	}

	@Override
	public List<User> getList() {
		
		// Dao 메서드를 통해 리스트 불러오기
		List<User> resultList = userDao.userSelectAll();
		
		// 중복 확인 하기
		if (resultList == null ) {
			System.out.println("가입된 유저가 없습니다");
			return null;
		} else { // 만약 리스트가 있으면 리스트 반환
			return resultList;
		}
		
	}

	@Override
	@Transactional
	public void modifyUser(User user) {
		System.out.println("여기까지 잘 왔다!");
		userDao.updateUser(user);
		
	}

	
	@Override
	@Transactional
	public void removeUser(String userId) {
		
		userDao.deleteUser(userId);
	}

	@Override
	public User login(String userId, String userPwd) {
		
		// 아이디에 맞는 유저를 가져오고
		User getUser = userDao.selectByUserId(userId);
		
		// 비밀번호까지 맞는지 확인
		if(getUser != null && getUser.getUserPwd().equals(userPwd)) {
			return getUser;
		}
		
		// 아니면 null 반환
		return null;
	}



}
