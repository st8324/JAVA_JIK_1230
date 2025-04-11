package kr.kh.spring2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		if(user == null) {
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}
