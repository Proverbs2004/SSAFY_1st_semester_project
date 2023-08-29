package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.WishList;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.model.service.WishService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-wish")
@Api(tags = "위시 컨트롤러")
@CrossOrigin("*")
public class WishListRestController {

	@Autowired
	private WishService wishService;
	
	@PostMapping("/like")
	public ResponseEntity<?> addWish(@RequestBody WishList wishList){
		
		System.out.println("여기는 라이크 컨트롤러");
		System.out.println(wishList.getUserId());
		System.out.println(wishList.getVideoSeq());
		int result = wishService.addWish(wishList);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/list/{userId}")
	public ResponseEntity<?> getUserList (@PathVariable String userId) {
		
		List<WishList> result = wishService.selectWish(userId);
		
		return new ResponseEntity<List<WishList>>(result,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{wishSeq}")
	@CrossOrigin(origins = "http://localhost:9999")
	public ResponseEntity<?> deleteWish (@PathVariable int wishSeq) {
		
		wishService.deleteWish(wishSeq);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
