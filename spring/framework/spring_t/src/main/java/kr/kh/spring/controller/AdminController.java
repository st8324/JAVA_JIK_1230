package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/board")
	public String board(Model model) {
		//모든 게시판을 가져와서 화면에 전송
		List<BoardVO> list = postService.getBoardList();
		
		model.addAttribute("list", list);
		return "/admin/board";
	}
}
