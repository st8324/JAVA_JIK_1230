package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.service.MessageService;
import kr.kh.spring.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/board")
	public String board(Model model) {
		//모든 게시판을 가져와서 화면에 전송
		List<BoardVO> list = postService.getBoardList();
		
		model.addAttribute("list", list);
		return "/admin/board";
	}
	@PostMapping("/board/insert")
	public String boardInsert(String bo_name, HttpServletResponse response, HttpServletRequest request) {
		
		if(postService.insertBoard(bo_name)) {
			messageService.sendMessage(response, request, "게시판을 등록했습니다.", "/admin/board");
		}else {
			messageService.sendMessage(response, request, "게시판을 등록하지 못했습니다.", "/admin/board");
		}
		
		return "/admin/board";
	}
}
