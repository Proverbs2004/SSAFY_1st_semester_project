package com.ssafy.ssafit.controller;

import java.awt.Checkbox;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-user")
@Api(tags = "유저 컨트롤러")
@CrossOrigin("*")
public class UserRestController {

	// service주입 받기
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	// 회원가입
	// 값을 받아 보낼 것이기 때문에 postmapping 사용
	@PostMapping("/signup")
	@ApiOperation(value = "회원가입")
	public ResponseEntity<?> signup(@RequestBody User user) {
		
		
		// 유저 등록
		int result = userService.signup(user);
		// 등록에 성공한 경우, 유저 정보를 반환
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		
		
	}
	
	// 유저 id로 불러오기 
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById (@PathVariable String userId){
		System.out.println(userId);
		System.out.println("요기!");
//		userService.searchUserById(userId);
		
		return new ResponseEntity<User>(userService.searchUserById(userId), HttpStatus.OK);
		
	}
	
	// 유저 포인트별로 정렬해서가져오기
	@GetMapping("/point")
	public ResponseEntity<?> getUserListByPoint (){
		
		return new ResponseEntity<List<User>>(userService.searchByMnpointDesc(), HttpStatus.OK);
	}
	
	
	// 유저 리스트 전체 가져오기
	@GetMapping("/list")
	public ResponseEntity<?> getUserList () {
		
		return new ResponseEntity<List<User>>(userService.getList(),HttpStatus.OK);
	}
	 
	// 유저 정보 변경
	@PutMapping("/update")
	public ResponseEntity<?> updateUser (@RequestBody User user){
		System.out.println("여긴 업데이트 컨트롤러");
		System.out.println(user.getUserId());
		userService.modifyUser(user);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	
	// 유저 삭제
	@DeleteMapping("/delete/{userId}")
	@CrossOrigin(origins = "http://localhost:9999")
	public ResponseEntity<?> deleteUser (@PathVariable String userId) {
		
		userService.removeUser(userId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 로그인 (실제 수행)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {

		Map<String, Object> result = new HashMap<String, Object>();

		// user를 이용해서 Service -> Dao -> DB를 통해 실제 유저인지 확인을 해야한다.
		// 우리는 하지 않겠다. ㅎ 직접 해볼것
		// 아이디가 널이 아니거나 길이가 있거나
		User check = userService.searchUserById(user.getUserId());
		

		if (!check.getUserId().equals(user.getUserId())|| !check.getUserPwd().equals(user.getUserPwd())) {
		    // 아이디가 다를 때의 처리를 여기에 추가합니다.
			System.out.println(check.getUserId());
			System.out.println(check.getUserPwd());
			System.out.println(user.getUserId());
			System.out.println(user.getUserPwd());
		    result.put("message", FAIL);
		    result.put("error", "아이디가 일치하지 않습니다."); // 에러 메시지 추가
		    HttpStatus status = HttpStatus.BAD_REQUEST; // 예시로 BadRequest(400) 상태 코드 사용
		    
//		    return null;
		}
		
		HttpStatus status = null;
		
		try {
			if (user.getUserId() != null || user.getUserId().length() > 0) {
				result.put("access-token", jwtUtil.createToken("userId", user.getUserId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;

			}else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;

			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		}
		return new ResponseEntity<Map<String,Object>>(result, status);
	}

	// 로그아웃
	@DeleteMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		
		session.removeAttribute("loginUser");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

}
