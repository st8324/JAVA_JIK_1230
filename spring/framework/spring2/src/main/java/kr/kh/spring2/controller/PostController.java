package kr.kh.spring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/list")
	public String list(Model model) {
		//게시판 목록을 서비스에게 요청하여 가져온 후 화면에 전송
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		return "/post/list";
	}

	@PostMapping("/list")
	public String listPost(Model model, @RequestParam int num) {
		//num를 서비스에게 주면서 게시판 번호에 맞는 게시글 목록 중 2개를 가져오라고 요청.
		List<PostVO> list = postService.getPostList(num);
		//가져온 게시글 목록을 화면에 전송
		model.addAttribute("list", list);
		return "post/sub";
	}
}
