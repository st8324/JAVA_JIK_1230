package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.CommentService;

//컨트롤러 안의 모든 메소드에 @ResponseBody가 붙은 경우에 사용
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/insert")
	@ResponseBody
	public boolean insert(@RequestBody CommentVO comment, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		return commentService.insertComment(comment, user);
	}
	
	@GetMapping("/list2")
	public String list2(Model model, Criteria cri) {
		
		List<CommentVO> list= commentService.getCommentList(cri);
		PageMaker pm = commentService.getPageMaker(cri);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/comment/list";
	}
	@PostMapping("/list")
	public String list(Model model,@RequestBody Criteria cri) {
		cri.setPerPageNum(5);
		List<CommentVO> list= commentService.getCommentList(cri);
		PageMaker pm = commentService.getPageMaker(cri);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "comment/list";
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestParam int co_num, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		return commentService.deleteComment(co_num, user);
	}
}
