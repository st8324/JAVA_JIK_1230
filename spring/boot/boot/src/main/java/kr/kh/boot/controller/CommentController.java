package kr.kh.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.boot.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import kr.kh.boot.model.vo.*;


@RequestMapping("/comment")
@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@PostMapping("/insert")
	@ResponseBody
	public boolean insert(@RequestBody CommentVO comment, @AuthenticationPrincipal CustomUser customUser) {
		return commentService.insertComment(comment, customUser);
	}
	
}
