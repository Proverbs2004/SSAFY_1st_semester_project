package com.ssafy.ssafit.model.dto;

// database에 따라 만들어줌
public class User {
	
	private int userSeq;
	private String userName;
	private String userId;
	private String userPwd;
	private String userNickname;
	private String userType;
	private int userMnpoint;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userSeq, String userName, String userId, String userPwd, String userNickname, String userType,
			int userMnpoint) {
		super();
		this.userSeq = userSeq;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickname = userNickname;
		this.userType = userType;
		this.userMnpoint = userMnpoint;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserMnpoint() {
		return userMnpoint;
	}

	public void setUserMnpoint(int userMnpoint) {
		this.userMnpoint = userMnpoint;
	}
	
	
	
	
	
}