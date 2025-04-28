package kr.kh.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "user/signup";
	}
	
}
