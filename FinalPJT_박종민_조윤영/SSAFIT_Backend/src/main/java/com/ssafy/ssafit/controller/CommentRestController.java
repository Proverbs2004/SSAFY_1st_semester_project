package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ssafit.model.dto.Comment;
import com.ssafy.ssafit.model.service.CommentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-comment")
@Api(tags = "코멘트 컨트롤러")
@CrossOrigin("*")
public class CommentRestController {
    
	@Autowired
    private CommentService commentService;
    
	@GetMapping("/{commentArticleSeq}")
	public ResponseEntity<?> selectAllComment(@PathVariable int commentArticleSeq){
		return new ResponseEntity<List<Comment>>(commentService.selectAllComment(commentArticleSeq), HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> registComment(@RequestBody Comment comment){
		int result = commentService.registComment(comment);
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
    
	@PutMapping("/update")
	public ResponseEntity<?> updateComment(Comment comment){
		int result = commentService.modifyComment(comment);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/{commentSeq}")
	public ResponseEntity<?> deleteComment(@PathVariable int commentSeq){
//		int result = commentService.removeComment(commentSeq);
		
		return new ResponseEntity<Integer>(commentService.removeComment(commentSeq), HttpStatus.OK);
	}
	
}