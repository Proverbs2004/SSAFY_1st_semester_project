package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.service.ArticleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-board") 
@Api(tags = "보드 컨트롤러")
@CrossOrigin("*")
public class BoardRestController {
    
	@Autowired
    private ArticleService articleService;
    
	// 전체 게시글 가져오기
	@GetMapping("/selectAll")
	public ResponseEntity<?> selectAllArticle(){
		return new ResponseEntity<List<Article>>(articleService.selectAllArticle(), HttpStatus.OK);
	}
	
	// 게시글 등록
	@PostMapping("/upload")
	public ResponseEntity<?> registArticle(@RequestBody Article article){
		System.out.println(article); // articleSeq랑 articleRegDate가 null로 뜸.. db에는 잘되는뎅
		int result = articleService.registArticle(article);
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	
	// 특정 게시물 가져오기
	// 아티클 번호로 검색(게시글 상세 페이지)
	@GetMapping("/board/{articleSeq}")
	public ResponseEntity<?> selectArticleBySeq(@PathVariable int articleSeq){
		return new ResponseEntity<Article>(articleService.selectArticleBySeq(articleSeq), HttpStatus.OK);
	}
	
	// 게시글 수정
	@PutMapping("/update")
	public ResponseEntity<?> updateArticle(Article article){
		System.out.println(article);
		articleService.modifyArticle(article);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
//	// 게시글 수정
//	@PutMapping("/update")
//	public ResponseEntity<?> updateArticle(@RequestBody Article article){
//		int result = articleService.modifyArticle(article);
//		System.out.println(article);
//		return new ResponseEntity<Integer>(result, HttpStatus.OK);
//	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{articleSeq}")
	public ResponseEntity<?> deleteArticle(@PathVariable int articleSeq){
//		int result = articleService.removeArticle(articleSeq);
		
		return new ResponseEntity<Integer>(articleService.removeArticle(articleSeq), HttpStatus.OK);
	}
	
	
	
	// 게시판 종류별 
	@GetMapping("/selectByType")
	public ResponseEntity<?> selectArticleByType(String type){
		return new ResponseEntity<List<Article>>(articleService.selectArticleByType(type), HttpStatus.OK);
	}
	
	// 제목별
	@GetMapping("/selectByTitle")
	public ResponseEntity<?> selectArticleByTitle(String title){
		return new ResponseEntity<List<Article>>(articleService.selectArticleByTitle(title), HttpStatus.OK);
	}
	
	// 작성자별
	@GetMapping("/selectByWriter")
	public ResponseEntity<?> selectArticleByWriter(String userId){
		return new ResponseEntity<List<Article>>(articleService.selectArticleByWriter(userId), HttpStatus.OK);
	}
	
	
}



