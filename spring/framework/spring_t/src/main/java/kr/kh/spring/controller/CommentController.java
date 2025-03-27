package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.service.CommentService;

//컨트롤러 안의 모든 메소드에 @ResponseBody가 붙은 경우에 사용
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/insert")
	public boolean insert(@RequestBody CommentVO comment) {
		return commentService.insertComment(comment);
	}
}
