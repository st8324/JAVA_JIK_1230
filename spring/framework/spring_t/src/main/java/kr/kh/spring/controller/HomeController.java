package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/* @Controller
 *  => HandlerMapping에 url을 등록하기 위한 어노테이션
 * 
 * */
@Controller
public class HomeController {

	/* @RequestMapping
	 * => 처리할 URL 정보를 지정하는 어노테이션으로 해당 정보와 일치하는 경우 메소드를 호출하여 실행
	 * => value : 처리할 URL을 지정
	 * => method : 리퀘스트 메소드 처리 방식을 지정. GET, POST, PUT, DELETE 등
	 * 
	 * @GetMapping
	 * => @RequestMapping(method = RequestMethod.GET)인 경우 대체할 수 있는 어노테이션
	 * 
	 * @PostMapping
	 * => @RequestMapping(method = RequestMethod.POST)인 경우 대체할 수 있는 어노테이션 
	 * */
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String home(Model model) {

		/* 화면에 데이터를 전송하는 방법
		 * - Model 객체를 이용하여 전송
		 * - addAttribute("화면에서 쓸 이름", 데이터);
		 * */
		model.addAttribute("name", "홍길동");
		
		/* 컨트롤러가 Dispatcher Servlet(이하 디스패처)에게 home이라는 문자열을 반환 
		 * => 디스패처가 View Resolver(이하 뷰 리졸버)에게 home이라는 문자열을 전달
		 * => 뷰 리졸버는 설정된 방법에 따라 home을 가공 함 
		 *    => 뷰 리졸버 설정은 servelt-context.xml에 있음 
		 *    => 기본 뷰 리졸버에 의해 /WEB-INF/view/home.jsp가 완성되어
		 *       최종적으로 해당 jsp의 결과 화면을 클라이언트에 전송
		 * */
		return "home";
	}
	
}
