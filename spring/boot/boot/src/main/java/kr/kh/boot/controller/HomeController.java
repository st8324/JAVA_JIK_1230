package kr.kh.boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import kr.kh.boot.model.vo.MemberVO;
import kr.kh.boot.service.MemberService;



@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("url", "/");
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	


	@GetMapping("/test")
	public String test(Model model) {
		int num = (int)(Math.random()*10);
		
		String role = "";
		switch (num) {
			case 4,6,8:
				role = "ADMIN";
				break;
			case 3,5,7,9:
				role = "USER";
			break;
		}

		List<Integer> list = Arrays.asList(10,20,30,40);

		MemberVO user = new MemberVO();
		user.setMe_id("abc");
		user.setMe_pw("456");
		user.setMe_authority("USER");

		model.addAttribute("num", num);
		model.addAttribute("role", role);
		model.addAttribute("items", list);
		model.addAttribute("user", user);
		return "test";
	}
	
	@GetMapping("/test/{num}")
	public String testNum(@PathVariable int num) {
		System.out.println(num);
		return "test";
	}
	
	
}
