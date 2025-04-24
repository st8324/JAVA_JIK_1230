package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.boot.service.CommentService;
import kr.kh.boot.utils.*;

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
	
	@PostMapping("/list")
	public String list(Model model, @RequestBody CommentCriteria cri) {
		cri.setPerPageNum(3);
		List<CommentVO> list = commentService.getCommentList(cri);
		PageMaker pm = commentService.getPageMaker(cri);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "post/comment";
	}
	@PostMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestParam int co_num) {
		return commentService.deleteComment(co_num);
	}
}
