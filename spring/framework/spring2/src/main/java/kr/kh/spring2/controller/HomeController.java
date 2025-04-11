package kr.kh.spring2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVO member) {
		boolean res = memberService.signup(member);
		if(res) {
			return "redirect:/";
		}
		return "redirect:/signup";
	}
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
}
